package tests;

import java.util.ArrayList;
import java.util.List;

public class Overloading {

    public static void print(ArrayList<String> c) {
        System.out.println("ArrayList");
    }

    public static void print(List<String> c) {
        System.out.println("List");
    }

    public static void main(String[] args) {
        List<String> c = new ArrayList<>();
        print(c);
    }
}
