package javaCore1.part9.part9_3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class T1 {

  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("a", "aaa");
    map.put("b", "bbb");
    map.put("c", "ccc");
    ///默认值
    map.put("d",map.getOrDefault("d","ddd"));
    map.putIfAbsent("e","eee");
    //如果不存在就放进去
    map.putIfAbsent("e","eees");
    map.merge("e","sss",(e,s)->e+s);
    map.forEach((k, v) -> System.out.println("key:" + k + " value:" + v));

    //linkedhashmap
    Map<String, String> linkedMap = new LinkedHashMap<String, String>(16,0.75f,true);
    linkedMap.put("a", "aaa");
    linkedMap.put("b", "bbb");
    linkedMap.put("c", "ccc");
    linkedMap.get("a");
    linkedMap.forEach((k, v) -> System.out.println("key:" + k + " value:" + v));
  }
}
