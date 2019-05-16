package javaCore1.part6.part6_2.part6_2_3;

public class ClassOne implements Cloneable {

  private ClassTwo classTwo = new ClassTwo();

  public ClassTwo getClassTwo() {
    return classTwo;
  }

  public void setClassTwo(ClassTwo classTwo) {
    this.classTwo = classTwo;
  }

  /**
   * 浅克隆不会克隆内部引用
   * @return
   * @throws CloneNotSupportedException
   */
//  @Override
//  protected ClassOne clone() throws CloneNotSupportedException {
//    return (ClassOne) super.clone();
//  }

  /**
   * 深克隆克隆内部引用
   */
  @Override
  protected ClassOne clone() throws CloneNotSupportedException {
    ClassOne classOne = (ClassOne) super.clone();
    classOne.setClassTwo(classTwo.clone());
    return classOne;
  }
}
