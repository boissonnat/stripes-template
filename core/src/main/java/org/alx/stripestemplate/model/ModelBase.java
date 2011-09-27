package org.alx.stripestemplate.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
@MappedSuperclass
public class ModelBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date creationDate = new Date();

    ///////////////////////////////////
    //       GETTERS / SETTERS       //
    ///////////////////////////////////

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    ////////////////////////////
    // OVERRIDDEN FROM OBJECT //
    ////////////////////////////

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelBase modelBase = (ModelBase) o;

        return id.equals(modelBase.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
