package javaCore1.part8.fx;

import jvm.testInit.SubClass;

public class ParTT<T> {

  private T frist;
  private T seconde;

  public T getFrist() {
    return frist;
  }

  public void setFrist(T frist) {
    this.frist = frist;
  }

  public T getSeconde() {
    return seconde;
  }

  public void setSeconde(T seconde) {
    this.seconde = seconde;
  }
}
