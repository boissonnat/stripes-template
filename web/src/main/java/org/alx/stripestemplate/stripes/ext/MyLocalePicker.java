package org.alx.stripestemplate.stripes.ext;

import net.sourceforge.stripes.localization.DefaultLocalePicker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
public class MyLocalePicker extends DefaultLocalePicker {
    public static final String LOCALE = "locale";

    @Override
    public Locale pickLocale(HttpServletRequest request) {
        HttpSession session = request.getSession();

        // Look in the request.
        String locale = request.getParameter(LOCALE);
        if (locale != null) {
            session.setAttribute(LOCALE, locale);
        }
        // Not found in the request? Look in the session.
        else {
            locale = (String) session.getAttribute(LOCALE);
        }
        // Use the locale if found.
        if (locale != null) {
            return new Locale(locale);
        }
        // Otherwise, use the default.
        return super.pickLocale(request);
    }
}
