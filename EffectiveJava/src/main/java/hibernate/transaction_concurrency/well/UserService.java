package hibernate.transaction_concurrency.well;

public class UserService {
    private DaoManager<? extends CrubDao<?>> daoManager = DaoManagerFactory.getDaoManager();

    public void createUser(String name) {
        User u = daoManager.processTransaction(new DaoCommand<User>() {
            @Override
            public User execute(DaoManager<?> manager) {
                UserDao userDao = (UserDao) manager.getDao(UserDao.class);
                System.out.println(userDao);
                return userDao.save(new User());
            }
        });
        System.out.println(u);
    }
}
