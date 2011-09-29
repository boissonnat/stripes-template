package org.alx.stripestemplate.action

import net.sourceforge.stripes.action.UrlBinding
import net.sourceforge.stripes.action.HandlesEvent
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.ForwardResolution
import org.alx.stripestemplate.model.MyFakeObject
import net.sourceforge.stripes.validation.ValidateNestedProperties
import net.sourceforge.stripes.validation.Validate
import net.sourceforge.stripes.action.RedirectResolution
import net.sourceforge.stripes.action.SimpleMessage
import net.sourceforge.stripes.action.DontValidate
import javax.annotation.security.RolesAllowed
import org.alx.stripestemplate.util.AppConstants

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
@RolesAllowed("User")
@UrlBinding('/mfo/{$event}/{id}')
class MyFakeObjectActionBean extends BaseActionBean {

    private static final String VIEW = '/WEB-INF/jsp/user/mfo-view.jsp'
    private static final String LIST = '/WEB-INF/jsp/user/mfo-list.jsp'
    private static final String ADD = '/WEB-INF/jsp/user/mfo-add.jsp'
    private static final String EDIT = '/WEB-INF/jsp/user/mfo-edit.jsp'

    String id

    @ValidateNestedProperties([@Validate(field="name",  required=true)])
    MyFakeObject myFakeObject

    @DontValidate
    @HandlesEvent('view')
    Resolution view(){
        return new ForwardResolution(VIEW)
    }

    @DontValidate
    @HandlesEvent('list')
    Resolution list(){
        return new ForwardResolution(LIST)
    }

    @DontValidate
    @HandlesEvent('add')
    Resolution add(){
        return new ForwardResolution(ADD)
    }

    @DontValidate
    @HandlesEvent('edit')
    Resolution edit(){
        myFakeObject = getFakeObject()
        return new ForwardResolution(EDIT)
    }

    @DontValidate
    @HandlesEvent('delete')
    Resolution delete(){
        store.delete(getFakeObject())
        context.messages.add(new SimpleMessage("MyFakeObject deleted !"))
        return new RedirectResolution(MyFakeObjectActionBean.class, 'list')
    }

    Resolution create(){
        store.save(myFakeObject)
        context.messages.add(new SimpleMessage("new MyFakeObject created !"))
        RedirectResolution ret = new RedirectResolution(MyFakeObjectActionBean.class, 'view')
        ret.addParameter('id', Integer.valueOf(myFakeObject.id))
        return ret

    }

    Resolution update(){
        store.save(myFakeObject)
        context.messages.add(new SimpleMessage("MyFakeObject updated !"))
        RedirectResolution ret = new RedirectResolution(MyFakeObjectActionBean.class, 'view')
        ret.addParameter('id', Integer.valueOf(myFakeObject.id))
        return ret
    }

    @DontValidate
    Resolution cancel(){
        context.messages.add(new SimpleMessage("Operation aborted !"))
        return new RedirectResolution(MyFakeObjectActionBean.class, 'list')
    }

    MyFakeObject getFakeObject(){
        return store.load(MyFakeObject.class, Integer.valueOf(id))
    }

    List<MyFakeObject> getAllObjects(){
        return store.load(MyFakeObject.class)
    }
}
