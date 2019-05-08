package jvm.testInit.nowInit;

public class T1 {

  static {
    i = 5;
    //System.out.println(i);
  }

  static int i = 10;

  static {
    i = 50;
  }


  public static void main(String[] args) {
    System.out.println(T1.i);
  }
}
