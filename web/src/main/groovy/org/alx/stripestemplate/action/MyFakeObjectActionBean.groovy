package org.alx.stripestemplate.action

import net.sourceforge.stripes.action.UrlBinding
import net.sourceforge.stripes.action.HandlesEvent
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.ForwardResolution
import org.alx.stripestemplate.model.MyFakeObject

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
@UrlBinding('/mfo/{$event}/{id}')
class MyFakeObjectActionBean extends BaseActionBean {

    private static final String VIEW = '/WEB-INF/jsp/user/mfo-view.jsp'
    private static final String LIST = '/WEB-INF/jsp/user/mfo-list.jsp'

    String id

    @HandlesEvent('view')
    Resolution view(){
        return new ForwardResolution(VIEW)
    }

    @HandlesEvent('list')
    Resolution list(){
        return new ForwardResolution(LIST)
    }

    MyFakeObject getMyFakeObject(){
        return store.load(MyFakeObject.class, Integer.valueOf(id))
    }

    List<MyFakeObject> getAllObjects(){
        return store.load(MyFakeObject.class)
    }
}
