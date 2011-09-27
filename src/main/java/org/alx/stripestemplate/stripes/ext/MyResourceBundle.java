package org.alx.stripestemplate.stripes.ext;

import net.sourceforge.stripes.localization.DefaultLocalizationBundleFactory;

import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
public class MyResourceBundle extends ResourceBundle {
    private Locale locale;
    public MyResourceBundle(Locale locale) {
        this.locale = locale;
    }
    @Override
    public Enumeration<String> getKeys() {
        return null;
    }
    @Override
    protected Object handleGetObject(String fullKey) {
        Object result = null;
        // Look for a class name in the full key
        for (int i = fullKey.length() - 1; i > 0; i--) {
            if (fullKey.charAt(i) == '.' ) {
                String className = fullKey.substring(0, i);
                try {
                    Class.forName(className);
                    // Found a class name, use the rest as a key
                    String key = fullKey.substring(i + 1);
                    result = getResult(locale, className, key);
                }
                catch (ClassNotFoundException exc) {
                }
            }
        }
        if (result == null) {
            // Found nothing, try the application's default bundle
            String name= DefaultLocalizationBundleFactory.BUNDLE_NAME;
            result = getResult(locale, name, fullKey);
        }
        return result;
    }
    // Just returns null if the bundle or the key is not found,
    // instead of throwing an exception.
    private String getResult(Locale loc, String name, String key) {
        String result = null;
        ResourceBundle bundle = ResourceBundle.getBundle(name, loc);
        if (bundle != null) {
            try { result = bundle.getString(key); }
            catch (MissingResourceException exc) { }
        }
        return result;
    }
}
