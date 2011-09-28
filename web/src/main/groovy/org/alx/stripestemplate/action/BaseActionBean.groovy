package org.alx.stripestemplate.action

import net.sourceforge.stripes.action.ActionBean
import net.sourceforge.stripes.action.ActionBeanContext
import org.alx.stripestemplate.stripes.ext.MyActionBeanContext
import org.alx.stripestemplate.stripes.ext.MyLocalePicker
import javax.servlet.http.HttpServletRequest
import net.sourceforge.stripes.action.LocalizableMessage
import org.alx.stripestemplate.persistence.HibernateStore

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
class BaseActionBean implements ActionBean {

    private MyActionBeanContext context;

    public MyActionBeanContext getContext() {
        return context;
    }
    public void setContext(ActionBeanContext context) {
        this.context = (MyActionBeanContext) context;
    }

    public String getLastUrl() {
        HttpServletRequest req = getContext().getRequest();
        StringBuilder sb = new StringBuilder();

        // Start with the URI and the path
        String uri = (String)
            req.getAttribute("javax.servlet.forward.request_uri");
        String path = (String)
            req.getAttribute("javax.servlet.forward.path_info");
        if (uri == null) {
            uri = req.getRequestURI();
            path = req.getPathInfo();
        }
        sb.append(uri);
        if (path != null) { sb.append(path); }

        // Now the request parameters
        sb.append('?');
        Map<String,String[]> map =
            new HashMap<String,String[]>(req.getParameterMap());

        // Remove previous locale parameter, if present.
        map.remove(MyLocalePicker.LOCALE);

        // Append the parameters to the URL
        for (String key : map.keySet()) {
            String[] values = map.get(key);
            for (String value : values) {
                sb.append(key).append('=').append(value).append('&');
            }
        }
        // Remove the last '&'
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    protected LocalizableMessage getLocalizableMessage(String key, Object... parameters){
        return new LocalizableMessage(
            getClass().getName() + "." + key, parameters);
    }

    HibernateStore getStore(){
        return getContext().getStore()
    }

}
