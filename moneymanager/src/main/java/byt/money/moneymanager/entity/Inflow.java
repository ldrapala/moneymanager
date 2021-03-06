package byt.money.moneymanager.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lukasz
 */
@Entity
@Table(name="inflow")
public class Inflow extends IEntity {
    
    @Column(name="amount")
    private BigDecimal amount;
    
    @Column(name="name")
    private String name;
    
    @Column(name="details")
    private String details;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createdate")
    private Date date;
    
    @ManyToOne()
    @JoinColumn(name="person_id")
    private Person person;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal ammount) {
        this.amount = ammount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date dateInflow) {
        this.date = dateInflow;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
