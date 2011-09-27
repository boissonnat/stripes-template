package org.alx.stripestemplate.stripes.ext;

import net.sourceforge.stripes.action.ActionBeanContext;
import org.alx.stripestemplate.persistence.HibernateStore;
import org.alx.stripestemplate.stripes.noext.MyInitListener;
import org.alx.stripestemplate.stripes.noext.MyInitListener;
import org.alx.stripestemplate.stripes.noext.MyInitListener;

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
public class MyActionBeanContext extends ActionBeanContext {

  protected void setCurrent(String key, Object value) {
    getRequest().getSession().setAttribute(key, value);
  }

  public HibernateStore getStore(){
    return (HibernateStore) getServletContext().getAttribute(MyInitListener.CTX_STORE_KEY);
  }
}
