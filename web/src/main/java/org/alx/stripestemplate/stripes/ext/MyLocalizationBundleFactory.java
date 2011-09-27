package org.alx.stripestemplate.stripes.ext;

import net.sourceforge.stripes.config.Configuration;
import net.sourceforge.stripes.localization.LocalizationBundleFactory;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
public class MyLocalizationBundleFactory implements LocalizationBundleFactory{
    public ResourceBundle getFormFieldBundle(Locale locale) {
        return new MyResourceBundle(locale);
    }
    public ResourceBundle getErrorMessageBundle(Locale locale) {
        return new MyResourceBundle(locale);
    }
    public void init(Configuration configuration) { }
}
