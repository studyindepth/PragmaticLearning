package building_blocks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    static Map<String, String> map = new ConcurrentHashMap<>();
    
    
    
    static class MapReader implements Runnable {
        public void run() {
            System.out.println(map.size());
        }
    }

    static class MapWriter implements Runnable {
        public void run() {
            System.out.println(map.put(toString(), "1"));
        }
    }

    public static void main(String... s) throws Throwable {
        Thread w1 = new Thread(new MapWriter());
        Thread w2 = new Thread(new MapWriter());
        Thread w3 = new Thread(new MapWriter());

        Thread r1 = new Thread(new MapReader());
        Thread r2 = new Thread(new MapReader());
        Thread r3 = new Thread(new MapReader());

        w1.start();
        w2.start();
        w1.join();
        w2.join();

        r1.start();
        r2.start();

        r1.join();
        r2.join();

        w3.start();
        w3.join();

        r3.start();
        r3.join();

    }
}
