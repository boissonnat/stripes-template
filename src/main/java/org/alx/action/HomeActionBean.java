package org.alx.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

@UrlBinding("/Home.htm")
public class HomeActionBean extends BaseActionBean {

    private static final String VIEW = "/WEB-INF/jsp/home.jsp";

    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }

    public String getJavaVersion() {
        return System.getProperty("java.version");
    }

    public String getOsName() {
        return System.getProperty("os.name");
    }
}
