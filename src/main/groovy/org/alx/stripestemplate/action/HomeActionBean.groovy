package org.alx.stripestemplate.action

import net.sourceforge.stripes.action.DefaultHandler
import net.sourceforge.stripes.action.ForwardResolution
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.UrlBinding

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
@UrlBinding('/Home.htm')
class HomeActionBean extends BaseActionBean {

    private static final String VIEW = "/WEB-INF/jsp/home.jsp"

    @DefaultHandler
    Resolution view() {
        return new ForwardResolution(VIEW)
    }

}
