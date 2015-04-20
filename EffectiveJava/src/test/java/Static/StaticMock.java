package Static;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Static.class)
public class StaticMock {

    @Test
    public void test() {
        PowerMockito.mockStatic(Static.class);
        Mockito.when(Static.getName()).thenReturn("ass");
        System.out.println(Static.getName());
        Void v = Mockito.mock(Void.class);
        v.v();
        System.out.println(v.toString());
        System.out.println(v.cal(1, 2));
    }

}

class Void {
    void v() {
        System.out.println("void");
    }

    int cal(int a, int b) {
        return a + b;
    }

}