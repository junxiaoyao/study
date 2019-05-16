package javaCore1.part6.part6_2.part6_2_3;

public class ClassTwo implements Cloneable {

  @Override
  protected ClassTwo clone() throws CloneNotSupportedException {
    return (ClassTwo) super.clone();
  }
}
