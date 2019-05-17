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
  }

  public static void printExtends(ParTT<? extends SuperClass> parTT) {
    System.out.println(parTT.getFrist().getClass());
    parTT.getFrist().say();
  }

  public static void printSuper(ParTT<? super SonClass> parTT) {
    System.out.println(parTT.getFrist().getClass());
  }
}
