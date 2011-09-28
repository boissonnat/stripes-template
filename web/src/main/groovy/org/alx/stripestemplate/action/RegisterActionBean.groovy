package org.alx.stripestemplate.action

import net.sourceforge.stripes.action.UrlBinding
import net.sourceforge.stripes.action.DontValidate
import net.sourceforge.stripes.action.DefaultHandler
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.ForwardResolution
import org.alx.stripestemplate.model.User
import net.sourceforge.stripes.validation.ValidateNestedProperties
import net.sourceforge.stripes.validation.Validate
import org.alx.stripestemplate.stripes.noext.PasswordTypeConverter
import net.sourceforge.stripes.action.RedirectResolution
import org.alx.stripestemplate.model.Role
import org.alx.stripestemplate.util.AppConstants
import net.sourceforge.stripes.validation.ValidationMethod
import net.sourceforge.stripes.validation.ValidationErrors
import net.sourceforge.stripes.validation.LocalizableError
import net.sourceforge.stripes.validation.ValidationErrorHandler

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
@UrlBinding("/Register.htm")
class RegisterActionBean extends BaseActionBean implements ValidationErrorHandler{

    private static final String VIEW = "/WEB-INF/jsp/register.jsp";

     @ValidateNestedProperties([
        @Validate(field="email",  required=true),
        @Validate(field="password",  required=true,
            converter=PasswordTypeConverter.class)
    ])
    User user;

    @Validate(required=true, converter= PasswordTypeConverter.class)
    String confirmPassword

    @DontValidate
    @DefaultHandler
    Resolution view(){
        return new ForwardResolution(VIEW)
    }

    @DontValidate
    Resolution cancel(){
        return new RedirectResolution(HomeActionBean.class);
    }

    Resolution register(){
        List<Role> roles = new ArrayList<Role>();
        roles.add(store.findBy(Role.class, "name", AppConstants.ROLE_USER));
        user.setRoles(roles);
        store.save(user);

        return new RedirectResolution(LoginActionBean.class);
    }

    @ValidationMethod
    void validateUsernameAndPasswords(ValidationErrors errors){
        String email = user.getEmail()
        if (store.findBy(User.class, "email", email) != null) {
            errors.addGlobalError(
              new LocalizableError("emailAlreadyTaken", email))
        }
        if (!user.getPassword().equals(confirmPassword)) {
            errors.addGlobalError(
                new LocalizableError("passwordsDontMatch"))
        }
    }

    Resolution handleValidationErrors(ValidationErrors errors){
        if (errors.hasFieldErrors()) {
            errors.addGlobalError(
                new LocalizableError("allFieldsRequired"));
        }
        return null
    }
}
