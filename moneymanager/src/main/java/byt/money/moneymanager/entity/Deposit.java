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
@Table(name="deposit")
public class Deposit extends IEntity {
    
    @Column(name="amount")
    private BigDecimal amount;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createdate")
    private Date fromDate;
    
    @Column(name="duration")
    private int duration;
    
    @Column(name="interest")
    private BigDecimal interest;
    
    @ManyToOne()
    @JoinColumn(name="person_id")
    private Person person;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal ammount) {
        this.amount = ammount;
    }

    public Date getDate() {
        return fromDate;
    }

    public void setDate(Date date) {
        this.fromDate = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public Person getPersonId() {
        return person;
    }

    public void setPersonId(Person personId) {
        this.person = personId;
    }
    
}
