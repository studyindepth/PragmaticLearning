package effectivejava.chapter06;

import effectivejava.chapter06.NestedEnum.Type;

public class Enums {
    public static void main(String[] args) {
        for (Apple a : Apple.values()) {
            System.out.println(a.getSize());
        }
        System.out.println(Operation.PLUS.apply(1, 3));
        Operation op = Operation.valueOf("PLUS");
        System.out.println(op);

        System.out.println(4 | 8);
        System.out.println(Type.A);
        System.out.println(Apple.GREEN.size);
    }
}

/* only for example, not have any usage */
enum Apple {
    RED(100), GREEN(100);

    public int size;

    Apple(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

}

enum Operation {
    PLUS {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    DIVIDE {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    },
    MULTIPLE {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    };

    abstract double apply(double x, double y);
}
