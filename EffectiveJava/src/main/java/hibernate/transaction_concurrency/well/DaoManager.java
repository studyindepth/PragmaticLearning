package hibernate.transaction_concurrency.well;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
    // map to cache dao instances
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
        // this doesn't guarantee an invariant : instantiate a value and put it
        // into the map only its key is not in the map
        D d = dao.get(type.getCanonicalName());
        if (d == null) {
            // may create multiple instances, the later are not put but used
            d = newDaoInstance(daoTypes.get(type));
            dao.putIfAbsent(type.getCanonicalName(), d);
        }
        return d;
    }

    public D getDaoWell(Class<?> type) {
        // this doesn't guarantee an invariant : instantiate a value and put it
        // into the map only its key is not in the map

        // using two synchronization mechanisms
        String key = type.getCanonicalName();
        synchronized (this) {
            if (!dao.containsKey(key)) {
                D value = newDaoInstance(type);
                dao.put(key, value);
            }
        }
        return dao.get(key);
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
