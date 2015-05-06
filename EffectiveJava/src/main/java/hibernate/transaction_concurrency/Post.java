package hibernate.transaction_concurrency;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String content;

    public Post() {
    }

    public Post(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", content=" + content + "]";
    }

}
