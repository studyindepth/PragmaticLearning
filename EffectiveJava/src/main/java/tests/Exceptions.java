package tests;

public class Exceptions {

    public static void main(String[] args) throws ExA {
        AA b = new BB();
        System.out.println(b.compute(1, 1));
        System.out.println(2^16);
    }
}

class AA {
    float compute(int a, int b) throws ExA {
        return a + b;
    }

}

class BB extends AA {
    @Override
    float compute(int a, int b) throws ExA {
        return a * b;
    }

}

class ExA extends Exception {

}

class ExB extends Exception {

}