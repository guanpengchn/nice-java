public class Main {
    public static void main(String []args) {
        RedisSentinelClient redisSentinelClient = new RedisSentinelClient();
        String setRes = redisSentinelClient.set("123","test");
        System.out.println(setRes);

        String getRes = redisSentinelClient.get("123");
        System.out.println(getRes);
    }
}
