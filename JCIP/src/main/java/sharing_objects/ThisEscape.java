package sharing_objects;

public class ThisEscape {

    class Inner {
        public void in() {
            foo();
        }
    }

    public Inner getInner() {
        return new Inner();
    }

    public void foo() {
        System.out.println("foo");
    }
}
