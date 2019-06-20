package javaCore1.part8.fx;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-20 11:25
 */
public class FxClass<T> {
private T t;

  public FxClass(T t) {
    this.t = t;
  }

  public T getT() {
    return t;
  }

  public void setT(T t) {
    this.t = t;
  }
}
