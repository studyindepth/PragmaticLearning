package hibernate.transaction_concurrency.well;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("unchecked")
public class DaoManagerFactory {
    private static DaoManager<? extends CrubDao<?>> daoManager;
    static {
        Constructor<?>[] cxtors = DaoManager.class.getConstructors();
        cxtors[0].setAccessible(true);
        try {
            daoManager = (DaoManager<? extends CrubDao<?>>) cxtors[0].newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new DaoInstantiationException(e);
        }
    }

    public static DaoManager<? extends CrubDao<?>> getDaoManager() {
        return daoManager;
    }
}
