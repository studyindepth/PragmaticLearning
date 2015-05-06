package hibernate.transaction_concurrency;

public class UserService {
    // DIP
    private PostDao postDao;
    private UserDAO userDao;

    public UserService(PostDao postDao, UserDAO userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    public void createUserAndFirstPost(String name, String postContent) {
        try {
            SessionManager.startTransaction();
            userDao.save(new User(name));
            postDao.save(new Post(postContent));
            SessionManager.commitTX();
        } catch (Exception e) {
            SessionManager.rollbackTX();
        }
    }

    public void findAll() {
        SessionManager.startTransaction();
        System.out.println(postDao.findAll(Post.class));
        System.out.println(userDao.findAll(User.class));
        SessionManager.commitTX();
    }
}
