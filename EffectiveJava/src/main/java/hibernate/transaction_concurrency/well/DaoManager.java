package hibernate.transaction_concurrency.well;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

// Singleton
public class DaoManager<D> {
    private final SessionFactory sf;
    private final ConcurrentMap<String, D> dao = new ConcurrentHashMap<>();
    private final Map<Class, Class> daoTypes = new ConcurrentHashMap<>();

    private DaoManager() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration
                .getProperties());
        sf = configuration.buildSessionFactory(builder.build());
        System.out.println(daoTypes);
        daoTypes.put(UserDao.class, UserDaoImpl.class);
    }

    public D getDao(Class<?> type) {
        D d = dao.get(type.getCanonicalName());
        System.out.println(d);
        if (d == null) {
            d = newDaoInstance(daoTypes.get(type));
            System.out.println("=============>" + d);
            dao.putIfAbsent(type.getCanonicalName(), d);
        }
        return d;
    }

    @SuppressWarnings("unchecked")
    private D newDaoInstance(Class<?> type) {
        Constructor<?>[] cxtors = type.getConstructors();
        cxtors[0].setAccessible(true);
        try {
            System.out.println(sf);
            return (D) cxtors[0].newInstance(sf);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new DaoInstantiationException(e);
        }
    }

    public <R> R processTransaction(DaoCommand<R> command) {
        R result;
        try {
            sf.getCurrentSession().beginTransaction();
            result = command.execute(this);
            sf.getCurrentSession().getTransaction().commit();
            return result;
        } catch (HibernateException e) {
            try {
                sf.getCurrentSession().getTransaction().rollback();
            } catch (HibernateException e1) {
                // Log here
            }
            throw new DaoExecutionException(e);
        }
    }

}
