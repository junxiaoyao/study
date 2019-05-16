package javaCore1.part6.interface1;

public interface TwoInter {
  default void say() {
    System.out.println("i am a default method by TwoInter");
  }
}
