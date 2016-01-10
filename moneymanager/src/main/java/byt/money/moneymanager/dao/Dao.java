package byt.money.moneymanager.dao;

import byt.money.moneymanager.entity.IEntity;
import byt.money.moneymanager.service.ActiveUserService;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lukasz
 */
public abstract class Dao<T extends IEntity> {

    protected final SessionProvider sessionProvider;
    protected final Class<T> claz;
    protected final ActiveUserService activeUserService;

    public Dao(SessionProvider sessionProvider, Class<T> claz, 
            ActiveUserService activeUserService) {
        this.sessionProvider = sessionProvider;
        this.claz = claz;
        this.activeUserService = activeUserService;
    }

    public void create(T data) {
        Session session = sessionProvider.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(data);
        transaction.commit();
        session.close();
    }
    
    public abstract List<T> getNLastRaws(int n);

    public abstract List<T> getAll();

    public void update(T data) {
        Session session = sessionProvider.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.update(data);
        transaction.commit();
        session.close();
    }

    public void delete(T data) {
        Session session = sessionProvider.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.delete(data);
        transaction.commit();
        session.close();
    }
    
    protected List<T> get(String query){
        Session session = sessionProvider.getSession();
        SQLQuery createSQLQuery = session.createSQLQuery(query);
        createSQLQuery.addEntity(claz);
        List<T> result = createSQLQuery.list();
        session.close();
        return result;
    }

}
