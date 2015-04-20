package tests;

public class Strings {
    public static void main(String[] args) {
        String s1 = "ab" + "12";
        String s2 = "ab" + "12";
        s2 = s2.toLowerCase();
        String s3 = new String("ab" + "12");
        System.out.println((s1 == s2) + ", " + (s2 == s3));
    }
}
