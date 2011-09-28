package org.alx.stripestemplate.action

import net.sourceforge.stripes.action.DefaultHandler
import net.sourceforge.stripes.action.ForwardResolution
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.UrlBinding
import org.alx.stripestemplate.model.User
import org.alx.stripestemplate.util.AppConstants

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
@UrlBinding('/Home')
class HomeActionBean extends BaseActionBean {

    private static final String GUEST_HOME = "/WEB-INF/jsp/home.jsp";
    private static final String USER_HOME = "/WEB-INF/jsp/user/home.jsp";
    private static final String ADMIN_HOME = "/WEB-INF/jsp/admin/home.jsp";

    @DefaultHandler
    Resolution view() {
        User u = context.user
        if (!u){
            return new ForwardResolution(GUEST_HOME)
        }else if (u.hasRole(AppConstants.ROLE_USER)){
            return new ForwardResolution(USER_HOME)
        }else {
            return new ForwardResolution(ADMIN_HOME)
        }
    }
}
