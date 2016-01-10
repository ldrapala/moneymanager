package byt.money.moneymanager.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lukasz
 */
@Entity
@Table(name="person")
public class Person extends IEntity {
    
    @Column(name="login", unique=true)
    private String login;
    
    @Column(name="password")
    private String password;
    
    @OneToMany(mappedBy="person", fetch=FetchType.LAZY)
    private List<Expense> expenses = new ArrayList<>();
    
    @OneToMany(mappedBy="person", fetch=FetchType.LAZY)
    private List<Inflow> inflows = new ArrayList<>();
    
    @OneToMany(mappedBy="person", fetch=FetchType.LAZY)
    private List<Deposit> deposits = new ArrayList<>();

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<Inflow> getInflows() {
        return inflows;
    }

    public void setInflows(List<Inflow> inflows) {
        this.inflows = inflows;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }
    
}
