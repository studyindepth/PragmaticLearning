package hibernate.transaction_concurrency;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionManager {
    public static SessionFactory factory;

    static {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration
                .getProperties());
        factory = configuration.buildSessionFactory(builder.build());
    }

    public static Session getSession() {
        return factory.getCurrentSession();
    }

    public static void closeSession() {
        factory.getCurrentSession().close();
    }

    public static void startTransaction() {
        factory.getCurrentSession().beginTransaction();
    }

    public static void commitTX() {
        factory.getCurrentSession().getTransaction().commit();
    }

    public static void rollbackTX() {
        factory.getCurrentSession().getTransaction().rollback();
    }
}
