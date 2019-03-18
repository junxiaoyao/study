package redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jxy
 * @Date: 2019/3/13 16:53
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Map<String,String> hash=new HashMap<>();
        hash.put("sdsd","20");
        hash.put("sdq","251");
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        jedis.set("test","1161515156165");
        jedis.hmset("hash",hash);
        List<String> get=jedis.hmget("hash","sdq");
        System.out.println(get.get(0));
        System.out.println("获取："+jedis.get("test"));
        //jedis.del("test");
    }
}
