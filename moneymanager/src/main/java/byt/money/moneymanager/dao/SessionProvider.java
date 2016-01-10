package byt.money.moneymanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Lukasz
 */
public class SessionProvider {
    
    private final SessionFactory sessionFactory;

    public SessionProvider() {
        Configuration configuration = new Configuration();
        configuration.configure("./dbconf/hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(ssrb.build());
    }
    
    public Session getSession(){
        Session session = sessionFactory.openSession();
        return session;
    }
    
}
