package hibernate.transaction_concurrency.well;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DaoManager {
    private static SessionFactory factory;

    static {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration
                .getProperties());
        factory = configuration.buildSessionFactory(builder.build());
    }

    // private
}
