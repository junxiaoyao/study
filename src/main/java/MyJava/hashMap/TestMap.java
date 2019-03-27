package MyJava.hashMap;

import java.util.HashMap;

/**
 * @Auther: jxy
 * @Date: 2019/3/27 21:01
 * @Description:
 */
public class TestMap {
    public static void main(String[] args) {
        MyHashMap<String,String> myHashMap=new MyHashMap<>();
        myHashMap.put("1","1");
        myHashMap.put("2","2");
      //  myHashMap.put(null,"2222");
        for(int i=0;i<100;i++){
            String s=i+"";
            myHashMap.put(s,s);
        }
        String s=myHashMap.get(null);
        System.out.println();
    }
}
