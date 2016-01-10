package byt.money.moneymanager.dao;

import byt.money.moneymanager.entity.Person;
import java.util.List;

/**
 *
 * @author Lukasz
 */
public class PersonDao extends Dao<Person> {
    
    public PersonDao(SessionProvider sessionProvider) {
        super(sessionProvider, Person.class, null);
    }

    @Override
    public List<Person> getAll() {
        String query = "SELECT * FROM person";
        List<Person> result = get(query);
        return result;
    }

    @Override
    public List<Person> getNLastRaws(int n) {
        throw new UnsupportedOperationException();
    }
    
}
