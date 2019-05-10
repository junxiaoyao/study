package jvm.testInit.dynamic;

import java.util.ArrayList;
import java.util.List;

public class TestFx {

  //泛型擦除后，特征签名一致无法编译
  public static String method(List<String> list) {
    int i=50;long s=5;
    s+=i;
    return "";
  }

  //  public static void method(List<Character> list) {
//  }
//  public static int method(List<Character> list) {
//    return 1;
//  }

  public static void main(String[] args) {
    ArrayList<String> ss = new ArrayList<>();
    Integer t1=5;
    Integer t2=5;
    System.out.println(t1==t2);
    System.out.println(ss instanceof ArrayList);
  }
  public static void testBoolean(){
    if(true){
      System.out.println("1");
    }else {
      System.out.println(2);
    }
  }
}
