package org.alx.stripestemplate.model;

import org.hibernate.validator.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
@Entity
public class Role extends ModelBase {
    @NotNull
    private String name;

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "roles",
            targetEntity = User.class
    )
    private List<User> users;

    public Role() {}

    public Role(String name) {
        this.name = name;
    }

    ///////////////////////////////////
    //       GETTERS / SETTERS       //
    ///////////////////////////////////


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString(){
        return "["+name+"]";
    }
}
