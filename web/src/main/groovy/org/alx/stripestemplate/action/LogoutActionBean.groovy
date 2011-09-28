package org.alx.stripestemplate.action

import net.sourceforge.stripes.action.RedirectResolution
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.UrlBinding
import net.sourceforge.stripes.action.DefaultHandler

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
@UrlBinding('/Logout')
class LogoutActionBean extends BaseActionBean{

    @DefaultHandler
    public Resolution logout() {
        context.logout()
        return new RedirectResolution(HomeActionBean.class)

    }

}
