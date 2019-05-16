package javaCore1.enums;

public enum TestEnum {
  ONE("one"), TWO("two");
  private String name;

  TestEnum(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
  //  TestEnum(String name, String value) {
//
//  }
}
