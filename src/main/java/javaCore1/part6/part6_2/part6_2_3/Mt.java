package javaCore1.part6.part6_2.part6_2_3;

public class Mt {

  public static void main(String[] args) throws Exception{
    ClassOne classOne=new ClassOne();
    ClassOne classOne1=classOne.clone();
    System.out.println(classOne==classOne1);
    System.out.println(classOne.getClassTwo()==classOne1.getClassTwo());
  }
}
