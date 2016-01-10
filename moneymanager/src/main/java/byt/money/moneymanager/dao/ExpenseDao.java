package byt.money.moneymanager.dao;

import byt.money.moneymanager.entity.Expense;
import byt.money.moneymanager.service.ActiveUserService;
import java.util.List;

/**
 *
 * @author Lukasz
 */
public class ExpenseDao extends Dao<Expense> {

    public ExpenseDao(SessionProvider sessionProvider, ActiveUserService activeUserService) {
        super(sessionProvider, Expense.class, activeUserService);
    }

    @Override
    public List<Expense> getNLastRaws(int n) {
        String query = "SELECT * FROM expense WHERE person_id="+activeUserService.getPersonId()+" ORDER BY createdate ASC LIMIT "+n;
        List<Expense> result = get(query);
        return result;
    }

    @Override
    public List<Expense> getAll() {
        String query = "SELECT * FROM inflow";
        List<Expense> result = get(query);
        return result;
    }
    
}
