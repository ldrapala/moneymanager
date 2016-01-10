package byt.money.moneymanager.service;

import byt.money.moneymanager.dao.Dao;
import byt.money.moneymanager.entity.Person;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 *
 * @author Lukasz
 */
public class LoginService {

    private final Dao personDao;
    private final ActiveUserService activeUserProvider;

    public LoginService(Dao personDao, ActiveUserService activeUserProvider) {
        this.personDao = personDao;
        this.activeUserProvider = activeUserProvider;
    }

    public boolean tryLogin(String name, char userPassword[]) {
        boolean result = false;
        String passwordToDb = convert(userPassword);
        List<Person> persons = personDao.getAll();
        for (Person person : persons) {
            if (person.getLogin().equals(name) && person.getPassword().equals(passwordToDb)) {
                result = true;
                activeUserProvider.setPerson(person);
            }
        }
        return result;
    }
    
    public void register(String userName, char userPassword[], String email){
        String passwordToDb = convert(userPassword);
        Person person = new Person();
        person.setLogin(userName);
        person.setPassword(passwordToDb);
        personDao.create(person);
    }
    
    public boolean isUserNameUnique(String userName){
        boolean result = true;
        List<Person> persons = personDao.getAll();
        for (Person person : persons) {
            if(person.getLogin().equals(userName)){
                result = false;
                break;
            }
        }
        return result;
    }

    private String convert(char[] userPassword) {
        String result = null;
        try {
            String password = new String(userPassword);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder passwordToDb = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                passwordToDb.append(Integer.toHexString(0xFF & digest[i]));
            }
            result = passwordToDb.toString();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Problems with login: " + ex);
        }
        return result;
    }

}
