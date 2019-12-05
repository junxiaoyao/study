package javaCore1.part8.fx;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-20 11:25
 */
public class TestFax {

  public static void main(String[] args) {

    FxClass<Integer> fxClass=new FxClass<>(5);
    FxClass<Number> fxClass2=new FxClass<>(5.0);
    show(fxClass);
    show(fxClass2);
  }
  public static void show(FxClass<? extends Number> fxClass){
    System.out.println(fxClass.getT());
  }
}
