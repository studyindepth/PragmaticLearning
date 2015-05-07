package hibernate.transaction_concurrency.well;

public class UserService {
    private DaoManager<? extends CrubDao<?>> daoManager = DaoManagerFactory.getDaoManager();

    public void createUser(String name) {
        daoManager.processTransaction(new DaoCommand<User>() {
            @Override
            public User execute(DaoManager<? extends CrubDao<?>> manager) {
                manager.getDao(UserDao.class);
                return null;
            }
        });
    }
}
