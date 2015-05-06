package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

@Entity(name = "member")
public class Member extends LogicalEntity {

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "member_id")
    private int memberId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    private FirstName firstName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "fist")
    public String getFist() {
        return firstName.getFist();
    }

    public void setFist(String fist) {
        firstName.setFist(fist);
    }

    public int hashCode() {
        return firstName.hashCode();
    }

    public boolean equals(Object obj) {
        return firstName.equals(obj);
    }

    public String toString() {
        return firstName.toString();
    }

    public FirstName getFullName() {
        return firstName;
    }

    public void setFullName(FirstName firstName) {
        this.firstName = firstName;
    }

}
