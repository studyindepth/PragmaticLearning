package hibernate.transaction_concurrency.well;

import org.hibernate.SessionFactory;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public UserDaoImpl(SessionFactory sf) {
        super(sf);
    }

    @Override
    protected Class<?> getEntityType() {
        return User.class;
    }

}
