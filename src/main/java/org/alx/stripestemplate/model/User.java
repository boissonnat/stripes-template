package org.alx.stripestemplate.model;

import org.hibernate.validator.Email;
import org.hibernate.validator.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
@Entity
public class User extends ModelBase {

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    @ManyToMany(
            targetEntity=Role.class,
            cascade= CascadeType.ALL
    )
    private List<Role> roles;

    ///////////////////////////////////
    //       GETTERS / SETTERS       //
    ///////////////////////////////////


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
