package byt.money.moneymanager.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lukasz
 */
public class EventModel {
    
    private final Map<Key, Object> model;

    public EventModel() {
        model = new HashMap<>();
    }
    
    public enum Key {
        ID, DATE, AMOUNT, NAME, DETAILS, EVENT, DURATION, INTEREST, PERSON
    }
    
    public Object getValue(Key key){
        return model.get(key);
    }
    
    public void setData(Key key, Object value){
        model.put(key, value);
    }

}
