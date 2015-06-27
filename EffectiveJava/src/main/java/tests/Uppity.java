package tests;

public class Uppity {
    public static void main(String[] args) {
        String str1 = "lower", str2 = "LOWER", str3 = "UPPER";
        str1.toUpperCase();
        str1.replace("LOWER", "UPPER");
        System.out.println((str1.equals(str2)) + " " + (str1.equals(str3)));
    }
}

