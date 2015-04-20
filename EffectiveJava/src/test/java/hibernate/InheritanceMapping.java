package hibernate;

import org.junit.Test;

public class InheritanceMapping {

    @Test
    public void testMapping() {
        Member member = new Member();
        member.setName("toan");
        member.setEmail("email");
        
        UserDAO dao = new UserDAO();
        dao.saveMember(member);
    }
}
