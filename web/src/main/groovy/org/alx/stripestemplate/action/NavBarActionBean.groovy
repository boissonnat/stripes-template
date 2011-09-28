package org.alx.stripestemplate.action

import net.sourceforge.stripes.action.UrlBinding
import net.sourceforge.stripes.action.Resolution
import org.alx.stripestemplate.model.User
import net.sourceforge.stripes.action.ForwardResolution
import org.alx.stripestemplate.util.AppConstants
import net.sourceforge.stripes.action.DefaultHandler

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
@UrlBinding("/Navbar")
class NavBarActionBean extends BaseActionBean{
    private static final String GUEST_NVB = "/WEB-INF/jsp/navbar.jsp";
    private static final String USER_NVB = "/WEB-INF/jsp/user/navbar.jsp";
    private static final String ADMIN_NVB = "/WEB-INF/jsp/admin/navbar.jsp";

    @DefaultHandler
    Resolution view() {
        User u = context.user
        if (!u){
            return new ForwardResolution(GUEST_NVB)
        }else if (u.hasRole(AppConstants.ROLE_USER)){
            return new ForwardResolution(USER_NVB)
        }else {
            return new ForwardResolution(ADMIN_NVB)
        }
    }
}
