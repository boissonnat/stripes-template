package org.alx.stripestemplate.stripes.noext;

import net.sourceforge.stripes.util.Base64;
import net.sourceforge.stripes.validation.TypeConverter;
import net.sourceforge.stripes.validation.ValidationError;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Locale;

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
public class PasswordTypeConverter implements TypeConverter<String> {
    public String convert(String input, Class<? extends String> cls, Collection<ValidationError> errors){
        return hash(input);
    }
    public String hash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = md.digest(password.getBytes());
            return Base64.encodeBytes(bytes);
        }
        catch (NoSuchAlgorithmException exc) {
            throw new IllegalArgumentException(exc);
        }
    }

    public void setLocale(Locale locale) { }
}
