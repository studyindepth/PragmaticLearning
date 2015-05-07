package hibernate.transaction_concurrency.well;

import org.hibernate.Session;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public UserDaoImpl(Session session) {
        super(session);
    }

    @Override
    protected Class<?> getEntityType() {
        return User.class;
    }

}
