package hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FirstName {
    @Column(name = "fist_name")
    private String fist;

    public FirstName(String fist, String last) {
        this.fist = fist;
    }

    public String getFist() {
        return fist;
    }

    public void setFist(String fist) {
        this.fist = fist;
    }

    public FirstName() {
        super();
    }
}
