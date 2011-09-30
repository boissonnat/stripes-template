package org.alx.stripestemplate.model;

import org.hibernate.validator.NotNull;

import javax.persistence.Entity;

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
@Entity
public class MyFakeObject extends ModelBase{

    @NotNull
    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "'"+name+"'";
    }
}
