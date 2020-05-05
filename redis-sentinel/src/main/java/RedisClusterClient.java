import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class RedisClusterClient {
    /**
     * 集群连接测试
     */
    public void testJedisCluster() {
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("127.0.0.1", 6379));
        nodes.add(new HostAndPort("127.0.0.1", 6380));
        nodes.add(new HostAndPort("127.0.0.1", 6381));
        JedisCluster cluster = new JedisCluster(nodes);
        cluster.set("12345", "1000");
        System.out.println(cluster.get("key1"));
    }

}
