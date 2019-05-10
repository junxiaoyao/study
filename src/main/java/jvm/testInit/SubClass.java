package jvm.testInit;

public class SubClass {

  static {
    System.out.println("\\i am subclass");
  }
  public SubClass(){
    System.out.println("233");
  }
//\\
  public static int value = 12;
}
