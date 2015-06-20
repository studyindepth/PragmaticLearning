package tests;

public class Test {
    static int init(int i, String messsage) {
        System.out.print(messsage + " ");
        return i;
    }

    public static void main(String[] args) {
        System.out.print(Sub.b);
    }
}

interface Super {
    public static int a = Test.init(1, "Super");

}

interface Sub extends Super {
    public static int b = Test.init(2, "Sub");
}
