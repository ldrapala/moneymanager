package byt.money.moneymanager.dao;

import byt.money.moneymanager.entity.Inflow;
import byt.money.moneymanager.service.ActiveUserService;
import java.util.List;

/**
 *
 * @author Lukasz
 */
public class InflowDao extends Dao<Inflow> {

    public InflowDao(SessionProvider sessionProvider, ActiveUserService activeUserService) {
        super(sessionProvider, Inflow.class, activeUserService);
    }

    @Override
    public List<Inflow> getNLastRaws(int n) {
        String query = "SELECT * FROM inflow WHERE person_id="+activeUserService.getPersonId()+" ORDER BY createdate ASC LIMIT "+n;
        List<Inflow> result = get(query);
        return result;
    }

    @Override
    public List<Inflow> getAll() {
        String query = "SELECT * FROM inflow";
        List<Inflow> result = get(query);
        return result;
    }
    
}
