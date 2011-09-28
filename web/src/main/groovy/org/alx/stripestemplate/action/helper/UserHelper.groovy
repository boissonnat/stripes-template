package org.alx.stripestemplate.action.helper

import org.alx.stripestemplate.model.User
import org.alx.stripestemplate.action.BaseActionBean

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
class UserHelper extends BaseActionBean{

    public User getUser(){
        return context.user
    }
}