package javaCore1.part8.fx;

public class MainT {

  public static void main(String[] args) {
    ParTT<? super SuperClass> parTT = new ParTT<>();
    parTT.setFrist(new SonClass());
    parTT.setSeconde(new SuperClass());
    ParTT<SonClass> pSon=new ParTT<>();
    pSon.setFrist(new SonClass());
    printExtends(pSon);
    printSuper(pSon);
    ParTT<SuperClass> pSub=new ParTT<>();
    pSub.setFrist(new SuperClass());
    printExtends(pSub);
    printSuper(pSub);
    System.out.println("------------------------------------------------");
    print(new MainT());
  }


  public static void printExtends(ParTT<? extends SuperClass> parTT) {
    System.out.println(parTT.getFrist().getClass());
    //parTT.getFrist().say();
    print( parTT.getFrist());
  }
  ///类型擦除后为限定类，因此无法调用say()
  public static void printSuper(ParTT<? super SonClass> parTT) {
    System.out.println(parTT.getFrist().getClass());
  }
  public  <T extends SuperClass> void prints(T t){
    t.say();
  }
  public static <T extends SuperClass> void print(T t){
    t.say();
  }
  public static <T> void print(T t){
    System.out.println(t.getClass().getSimpleName());
  }
}
