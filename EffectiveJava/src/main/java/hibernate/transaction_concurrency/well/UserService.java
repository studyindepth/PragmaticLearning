package hibernate.transaction_concurrency.well;

public class UserService {
    private DaoManager<? extends CrubDao<?>> daoManager = DaoManagerFactory.getDaoManager();

    public void createUser(String name) {
        User u = daoManager.processTransaction(new DaoCommand<User>() {
            @Override
            public User execute(DaoManager<?> manager) {
                // design to avoid casting
                UserDao userDao = (UserDao) manager.getDaoWell(UserDao.class);
                System.out.println(userDao);
                return userDao.save(new User());
            }
        });
        System.out.println(u);
    }
}
