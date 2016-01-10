package byt.money.moneymanager.entity;

import byt.money.moneymanager.common.Converter;
import byt.money.moneymanager.model.EventModel;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Lukasz
 */
@MappedSuperclass
public abstract class IEntity implements Serializable {
    
    @Column(name="id", unique=true)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}
