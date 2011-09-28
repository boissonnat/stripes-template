package org.alx.stripestemplate.action

import org.alx.stripestemplate.model.User
import net.sourceforge.stripes.validation.Validate
import net.sourceforge.stripes.action.DefaultHandler
import net.sourceforge.stripes.action.DontValidate
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.ForwardResolution
import net.sourceforge.stripes.action.RedirectResolution
import net.sourceforge.stripes.validation.ValidationMethod
import net.sourceforge.stripes.validation.ValidationErrors
import net.sourceforge.stripes.validation.LocalizableError
import org.alx.stripestemplate.stripes.noext.PasswordTypeConverter
import net.sourceforge.stripes.action.UrlBinding

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
@UrlBinding('/Login.htm')
class LoginActionBean extends BaseActionBean {

    private static final String VIEW = "/WEB-INF/jsp/login.jsp";

    private User user;

    @Validate(required=true)
    String email;

    String loginUrl;

    @Validate(required=true, converter= PasswordTypeConverter.class)
    String password;

    @DefaultHandler
    @DontValidate
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }
    public Resolution login() {
        getContext().setUser(user);

        if (loginUrl != null) {
            return new RedirectResolution(loginUrl);
        }
        return new RedirectResolution(HomeActionBean.class);
    }

    @ValidationMethod
    public void validateUser(ValidationErrors errors) {
        user = getStore().findBy(User.class, 'email', email)
        if (user == null) {
            errors.add("email",
                new LocalizableError("primaryEmailNotFound"));
        }
        else if (!user.getPassword().equals(password)) {
            errors.add("password",
                new LocalizableError("passwordIncorrect"));
        }
    }
}
