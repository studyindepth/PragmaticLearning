package collections;

import com.google.common.base.Function;

public class Transforms {
    public static void main(String[] args) {
        Function<String, String> toUpperCase = new Function<String, String>() {
            @Override
            public String apply(String input) {
                return input.toUpperCase();
            }
        };
        
        String s = "S";
        String s1 = s.toUpperCase();
        System.out.println(s1);
        System.out.println(s == s1);
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
    }
}
