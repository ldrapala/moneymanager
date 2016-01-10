package byt.money.moneymanager.service;

import byt.money.moneymanager.entity.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukasz
 */
public class ActiveUserService {
    
    private final List<ActiveUserListener> listeners;
    private long personId = -1;
    private Person person;

    public ActiveUserService() {
        listeners = new ArrayList<>();
    }
    
    public boolean isUserLogin(){
        boolean result = personId != -1;
        return result;
    }

    public long getPersonId() {
        return personId;
    }
    
    public Person getPerson(){
        return person;
    }

    public void setPerson(Person person) {
        personId = person.getId();
        this.person = person;
        notifyListeners();
    }
    
    private void notifyListeners(){
        boolean userLogin = isUserLogin();
        for (ActiveUserListener listener : listeners) {
            listener.notify(userLogin);
        }
    }
    
    public void registerListener(ActiveUserListener listener){
        listeners.add(listener);
        notifyListeners();
    }
    public void unregisterListener(ActiveUserListener listener){
        listeners.remove(listener);
    }
    
}
