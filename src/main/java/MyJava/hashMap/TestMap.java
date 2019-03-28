package MyJava.hashMap;

import java.util.HashMap;

/**
 * @Auther: jxy
 * @Date: 2019/3/27 21:01
 * @Description:
 */
public class TestMap {
    public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put(null,"null");
        for (int i = 0; i < 50; i++) {
            String s = i + "";
            myHashMap.put(s, s);
        }
        for (int i = 0; i < 50; i++) {
            String s =""+ i ;
            myHashMap.put(s, "new:"+s);
        }
       myHashMap.printMap();
        System.out.println(myHashMap.get(null));
        for (int i = 0; i < 50; i++) {
            String s = i + "";
            System.out.println("key:"+i+"v:"+myHashMap.get(s));
        }
        System.out.println(myHashMap.size());
    }
}
