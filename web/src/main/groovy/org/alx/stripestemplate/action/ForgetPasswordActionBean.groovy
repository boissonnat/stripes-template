package org.alx.stripestemplate.action

import net.sourceforge.stripes.action.UrlBinding
import net.sourceforge.stripes.validation.Validate
import net.sourceforge.stripes.action.DefaultHandler
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.ForwardResolution
import net.sourceforge.stripes.action.DontValidate
import net.sourceforge.stripes.action.RedirectResolution
import net.sourceforge.stripes.action.SimpleMessage
import javax.mail.Session
import javax.mail.internet.MimeMessage
import javax.mail.Message
import javax.mail.internet.InternetAddress
import org.alx.stripestemplate.stripes.ext.MyLocalizationBundleFactory
import net.sourceforge.stripes.controller.StripesFilter
import org.alx.stripestemplate.model.User
import org.alx.stripestemplate.stripes.noext.PasswordTypeConverter
import javax.mail.Transport
import javax.mail.MessagingException
import java.security.SecureRandom
import net.sourceforge.stripes.validation.ValidationMethod
import net.sourceforge.stripes.validation.ValidationErrors
import net.sourceforge.stripes.validation.LocalizableError

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
@UrlBinding("/SendPassword")
class ForgetPasswordActionBean extends BaseActionBean{

    private static final String VIEW = "/WEB-INF/jsp/send-password.jsp"

    @Validate(required = true, mask = ".+@.+\\.[a-z]+")
    String email

    @DefaultHandler
    @DontValidate
    Resolution display(){
        return new ForwardResolution(VIEW)
    }

    @DontValidate
    Resolution cancel(){
        context.messages.add(new SimpleMessage("you've refound the memory ? ;-)"))
        return new RedirectResolution(LoginActionBean.class)
    }

    Resolution send(){
        //Here, no Authenticator argument is used (it is null).
        //Authenticators are used to prompt the user for user
        //name and password.
        Session session = Session.getDefaultInstance(getMailServerConfig(), null);
        MimeMessage message = new MimeMessage(session);
        try {
            //the "from" address may be set in code, or set in the
            //config file under "mail.from" ; here, the latter style is used
            //message.setFrom( new InternetAddress(emailaddresse) );
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));


            MyLocalizationBundleFactory c = (MyLocalizationBundleFactory)StripesFilter.getConfiguration().getLocalizationBundleFactory();
            String emailSubject = c.getFormFieldBundle(getContext().getLocale()).getString("email.subject");

            message.setSubject(emailSubject, "UTF-8");

            // Get the user
            User u = store.findBy(User.class, "email", email);

            // Reset its password
            String newPass = passwordGenerator();

            // Save the new user's password
            PasswordTypeConverter converter = new PasswordTypeConverter();
            u.setPassword(converter.hash(newPass));
            store.save(u);

            // Construct the email
            StringBuilder sb = new StringBuilder();
            sb.append(c.getFormFieldBundle(getContext().getLocale()).getString("email.corp.header"));
            sb.append("\n\n");
            sb.append(c.getFormFieldBundle(getContext().getLocale()).getString("email.corp.center"));
            sb.append(newPass);
            sb.append("\n\n");
            sb.append(c.getFormFieldBundle(getContext().getLocale()).getString("email.corp.footer"));

            // Send the new email by password
            message.setText(sb.toString(), "UTF-8");

            Transport.send(message);
        }
        catch (MessagingException ex){
             throw new RuntimeException("Sending mail failed...");
        }

        context.messages.add(new SimpleMessage("An email with your new password has been sent !"))
        return new RedirectResolution(LoginActionBean.class);
    }

    private String passwordGenerator(){
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    private Properties getMailServerConfig(){
        Properties props = new Properties();
        try {
            props.load(getClass().getResourceAsStream("/mail-server-config.properties"));
            return props;
        } catch (IOException e) {
            throw new RuntimeException("Load Mail server properties failed");
        }
    }

    @ValidationMethod
    public void validateEmail(ValidationErrors errors){
        if (store.findBy(User.class, "email", email) == null) {
            errors.addGlobalError(
                    new LocalizableError("unknownEmail", email));
        }
    }
}
