package nosql.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

public class PubSubs {

    static JedisPoolConfig config = new JedisPoolConfig();
    static JedisPool pool = new JedisPool(config, "localhost", 6379, 0);
    static Jedis jedis = pool.getResource();

    public static void main(String[] args) {
        final JedisPubSub subscribler = new RedisSubscriber();
        while (true) {
            jedis.subscribe(subscribler, "c");
            jedis.publish("java", "java jedis");
            jedis.subscribe(subscribler, "java");
        }
    }
}
