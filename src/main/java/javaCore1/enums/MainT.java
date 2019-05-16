package javaCore1.enums;

public class MainT {

  public static void main(String[] args) {
    TestEnum testEnum=Enum.valueOf(TestEnum.class,"TWO");
    int[] nums={2,1};
    System.out.println(nums.getClass());
    System.out.println(TestEnum.class==testEnum.getClass());
    System.out.println(testEnum.getClass().getName());
    System.out.println(testEnum.getName()+" "+testEnum.ordinal());
    System.out.println(TestEnum.ONE.getName());
  }
}
