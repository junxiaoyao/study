package jvm.testInit.nowInit;

public class TestGc {

  public static void main(String[] args) {
    //int a;
    //System.out.println(a);//局部变量不会初始化默认值
    // {
    byte[] bytes = new byte[64 * 1024 * 1024];
    // }
    //bytes = null;
//    Byte s =null;
    //int i=0;
    System.gc();
  }
}
