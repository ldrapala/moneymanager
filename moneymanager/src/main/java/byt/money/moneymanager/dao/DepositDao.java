package byt.money.moneymanager.dao;

import byt.money.moneymanager.entity.Deposit;
import byt.money.moneymanager.service.ActiveUserService;
import java.util.List;

/**
 *
 * @author Lukasz
 */
public class DepositDao extends Dao<Deposit>{

    public DepositDao(SessionProvider sessionProvider, ActiveUserService activeUserService) {
        super(sessionProvider, Deposit.class, activeUserService);
    }

    @Override
    public List<Deposit> getNLastRaws(int n) {
        String query = "SELECT * FROM deposit WHERE person_id="+activeUserService.getPersonId()+" ORDER BY createdate ASC LIMIT "+n;
        List<Deposit> result = get(query);
        return result;
    }

    @Override
    public List<Deposit> getAll() {
        String query = "SELECT * FROM deposit";
        List<Deposit> result = get(query);
        return result;
    }
    
}
