package sharing_objects;

public class SynchronizedObjects {
    public static void main(String[] args) {
        Object o = null;
        synchronized (o) {
            System.out.println("");
        }
    }
}
