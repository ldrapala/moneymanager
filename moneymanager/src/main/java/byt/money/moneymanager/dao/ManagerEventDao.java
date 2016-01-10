package byt.money.moneymanager.dao;

import byt.money.moneymanager.model.Event;
import byt.money.moneymanager.model.EventModel;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lukasz
 */
public class ManagerEventDao {
    
    private final Dao depositDao;
    private final Dao expenseDao;
    private final Dao inflowDao;
    private Map<Event, Dao> dao;

    public ManagerEventDao(Dao depositDao, Dao expenseDao, Dao inflowDao) {
        this.depositDao = depositDao;
        this.expenseDao = expenseDao;
        this.inflowDao = inflowDao;
        gatherDao();
    }
    
    private void gatherDao(){
        dao = new HashMap<>();
        dao.put(Event.INFLOW, inflowDao);
        dao.put(Event.DEPOSIT, depositDao);
        dao.put(Event.EXPENSES, expenseDao);
    }
    
    public void create(EventModel eventModel){
        Event event = (Event)eventModel.getValue(EventModel.Key.EVENT);
        Dao selectedDao = dao.get(event);
    }
    
}
