package sharing_objects;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class VolatileSynchronizedInteger {
    private volatile int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
