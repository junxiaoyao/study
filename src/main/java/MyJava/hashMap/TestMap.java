package MyJava.hashMap;

import java.util.HashMap;

/**
 * @Auther: jxy
 * @Date: 2019/3/27 21:01
 * @Description:
 */
public class TestMap {
  /*  public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        for (int i = 0; i < 10; i++) {
            String s = i + "";
            myHashMap.put(s, s);
        }
        myHashMap.put(null,"nullstr");
        myHashMap.printMap();
        String s=myHashMap.remove(null);
        myHashMap.printMap();
    }*/
    public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
/*        myHashMap.put("1","1");
        myHashMap.put("2","2");
        myHashMap.put("3","3");
        myHashMap.put("4","4");
        String s=myHashMap.remove("4");
        myHashMap.printMap();*/
       // myHashMap.put(null, "null");
        for (int i = 0; i < 50; i++) {
            String s = i + "";
            myHashMap.put(s, s);
        }
    /*    for (int i = 0; i < 50; i++) {
            String s = "" + i;
            myHashMap.put(s, "new:" + s);
        }*/
        myHashMap.printMap();
        System.out.println("---------------------------------------------------------------------------------------");
        for (int i = 0; i < 50; i++) {
            String s = i + "";
            System.out.println("remove key:"+i+"v:"+myHashMap.remove(s));
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------");

        myHashMap.printMap();
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println(myHashMap.get(null));
      /*  for (int i = 0; i < 50; i++) {
            String s = i + "";
            System.out.println("key:"+i+"v:"+myHashMap.get(s));
        }*/
        System.out.println(myHashMap.size());
    }
}
