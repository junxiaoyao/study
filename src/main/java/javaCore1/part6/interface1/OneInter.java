package javaCore1.part6.interface1;

public interface OneInter {

  default void say() {
    System.out.println("i am a default method by OneInter");
  }

   void cry();
}
