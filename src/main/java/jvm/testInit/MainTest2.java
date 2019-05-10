package jvm.testInit;


public class MainTest2 {

  public static void main(String[] args) {
    System.out.println(ConstClass.value);
    printLnH("bs");
  }
  public static void printLnH(String str){
    switch (str){
      case "hello":
        System.out.println("hello");break;
        default:
          System.out.println("bye");
    }
  }
}
