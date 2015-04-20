package annotation;

public class UseTest {
    @Test
    public void testPass() {

    }

    @Test
    public void testFail() {
        throw new AssertionError();
    }

    @Test
    @Expected(NullPointerException.class)
    public void testException() {
        throw new NullPointerException();
    }

}
