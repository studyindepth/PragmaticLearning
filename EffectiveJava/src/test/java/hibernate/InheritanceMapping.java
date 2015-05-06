package hibernate;

import org.junit.Test;

public class InheritanceMapping {

    @Test
    public void testMapping() {
        Member member = new Member();
        member.setName("toan");
        member.setEmail("email");
        member.setFullName(new FirstName("do", "toan"));
        UserDAO dao = new UserDAO();
        dao.saveMember(member);

    }
}
