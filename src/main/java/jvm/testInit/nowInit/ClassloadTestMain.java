package jvm.testInit.nowInit;

public class ClassloadTestMain {

  public static void main(String[] args)throws Exception {
    Object o = ClassloadTest.getClassByName("jvm.testInit.nowInit.ClassloadTest").newInstance();
    ClassloadTest c=new ClassloadTest();
    System.out.println(o.getClass());
    System.out.println(o instanceof jvm.testInit.nowInit.ClassloadTest);
    System.out.println(c instanceof jvm.testInit.nowInit.ClassloadTest);
  }
}
