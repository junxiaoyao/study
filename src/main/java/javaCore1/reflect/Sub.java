package javaCore1.reflect;

public class Sub {
  private String name;
  private int s;
  protected String sex;
  public String getName() {
    return name;
  }

  private void say(){
    System.out.println("i say i am cool");
  }

  public void setName(String name) {
    this.name = name;
  }
}
