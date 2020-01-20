package redis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
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
    public final static String REDIS_SEVER="192.168.231.66";
    public static void main(String[] args) {

        //testString();
        //testHash();
        testList();
        //jedis.del("test");
    }
    public static void testList(){
        Jedis jedis =getConnect();
     List<String> list=new ArrayList<>();
     list.add("ccx");
     list.add("cas");
     for (String st:list)
         jedis.lpush("list",st);
     String str=jedis.lpop("list");
     while (str!=null){
         System.out.println(str);
         str=jedis.lpop("list");
     }
    }
    public static void testString(){
        Jedis jedis =getConnect();
        jedis.set("T1","t1string");
        System.out.println(jedis.strlen("T1"));
    }
    public static void testHash(){
       Map<String,String> map=new HashMap<>();
        map.put("name","jxy");
        map.put("x","sc");
        Jedis jedis =getConnect();
        jedis.hmset("me",map);
        Map<String,String> re= jedis.hgetAll("me");
        System.out.println(jedis.hget("me","x"));
    }

    public static void test(){
        Map<String,String> hash=new HashMap<>();
        hash.put("sdsd","20");
        hash.put("sdq","251");
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.8.130");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        jedis.set("test","1161515156165");
        jedis.hmset("hash",hash);
        Map<String, String> map= jedis.hgetAll("hash");
        List<String> get=jedis.hmget("hash","sdq");
        System.out.println(get.get(0));
        System.out.println("获取："+jedis.get("test"));
    }
    public static Jedis getConnect(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis(REDIS_SEVER);
        return jedis;
    }
}



