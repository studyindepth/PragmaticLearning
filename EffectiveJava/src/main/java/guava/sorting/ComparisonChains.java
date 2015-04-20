package guava.sorting;

import com.google.common.collect.ComparisonChain;

public class ComparisonChains {

    public static void main(String[] args) {

        User u1 = new User();
        u1.lastName = "a";
        u1.firstName = "a";
        u1.name = "x";

        User u2 = new User();
        u2.lastName = "a";
        u2.firstName = "b";
        u2.name = "x";

        int i = ComparisonChain.start().compare(u1.lastName, u2.lastName).compare(u1.firstName, u2.firstName)
                .compare(u1.name, u2.name).result();
        //System.out.println(i);
        System.out.println("0".compareTo("3"));
    }

    static class User {
        String lastName;
        String firstName;
        String name;
    }
}
