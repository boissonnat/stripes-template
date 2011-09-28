package org.alx.stripestemplate.stripes.ext;

import net.sourceforge.stripes.action.ActionBeanContext;
import org.alx.stripestemplate.model.User;
import org.alx.stripestemplate.persistence.HibernateStore;
import org.alx.stripestemplate.stripes.noext.MyInitListener;
import org.alx.stripestemplate.stripes.noext.MyInitListener;
import org.alx.stripestemplate.stripes.noext.MyInitListener;

import javax.servlet.http.HttpSession;

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
public class MyActionBeanContext extends ActionBeanContext {

    private static final String USER = "user";

    public User getUser() {
        Integer userId = getCurrent(USER, null);
        if (userId == null) { return null ; }
        return (User) getStore().load(User.class, userId);
    }

    public void setUser(User user) {
        if (user != null) {
            setCurrent(USER, user.getId());
        }
        else {
            setCurrent(USER, null);
        }
    }

    public void logout() {
        setUser(null);

        HttpSession session = getRequest().getSession();
        if (session != null) {
            session.invalidate();
        }
    }

    protected <T> T getCurrent(String key, T defaultValue) {
        T value = (T) getRequest().getSession().getAttribute(key);
        if (value == null) {
            value = defaultValue;
            setCurrent(key, value);
        }
        return value;
    }

    protected void setCurrent(String key, Object value) {
        getRequest().getSession().setAttribute(key, value);
    }

    public HibernateStore getStore(){
        return (HibernateStore) getServletContext().getAttribute(MyInitListener.CTX_STORE_KEY);
    }
}
