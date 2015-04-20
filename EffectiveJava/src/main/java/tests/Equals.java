package tests;

import java.util.HashSet;

public class Equals {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;
        Integer c = new Integer(1);
        int d = 1;

        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(c == d);
    }
}

class Base1<T> {
}

class Sub1<T> extends Base1<T> {
}

class Base2<T> {
}

class Derived2<T> extends Base2<T> {
}

class Test3 {
    public static void main(String[] args) {
        Base2<? extends Number> b1 = new Base2<Number>();
        Base2<? extends Number> b2 = new Derived2<Number>();
        Base2<? extends Number> b3 = new Derived2<Integer>();
        Derived2<? extends Number> b4 = new Derived2<Integer>();
        Base2<?> b5 = new Derived2<Integer>();
        Derived2<?> b6 = new Derived2<Integer>();

    }
}

class Student {
    public Student(int r) {
        rollNo = r;
    }

    int rollNo;
}

class StudentTest {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();
        students.add(new Student(5));
        students.add(new Student(10));
        System.out.println(students.contains(new Student(10)));
    }
}