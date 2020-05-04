import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hzwangjunqiang1@corp.netease.com
 * @desc redis sentinel 使用
 */
public class RedisSentinelClient {
    private static JedisSentinelPool pool = null;
    private static String redisHosts = "192.168.199.194:6379;192.168.199.157:6379;";
    private static String redisMaster = "";//master name
    private static String password = "";//密码,可选
    private static final int MAX_IDLE = 200;//最大空闲数
    private static final int MAX_TOTAL = 400;//最大连接数
    private static final int MIN_IDLE = 200;//最小空闲数

    static {
        //redis 连接池配置
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(MAX_IDLE);
        poolConfig.setMaxTotal(MAX_TOTAL);
        poolConfig.setMinIdle(MIN_IDLE);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        Set<String> hosts = new HashSet<String>(Arrays.asList(redisHosts.split(";")));
        if (StringUtils.isBlank(password)) {
            pool = new JedisSentinelPool(redisMaster, hosts, poolConfig);
        } else {
            pool = new JedisSentinelPool(redisMaster, hosts, poolConfig, password);
        }
    }

    public String get(String key) throws JedisConnectionException {
        Jedis jedis = pool.getResource();
        try {
            return jedis.get(key);
        } catch (JedisConnectionException e) {
            throw e;
        } finally {
            jedis.close();
        }
    }

    public String set(String key, String value) throws JedisConnectionException {
        Jedis jedis = pool.getResource();
        try {
            return jedis.set(key, value);
        } catch (JedisConnectionException e) {
            throw e;
        } finally {
            jedis.close();
        }
    }
}
