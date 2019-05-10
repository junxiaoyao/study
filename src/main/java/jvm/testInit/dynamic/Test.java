package jvm.testInit.dynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class Test {

  class GrandFather {

    void say() {
      System.out.println("i am grandfather");
    }
  }

  class Father extends GrandFather {

    void say() {
      System.out.println("i am father");
    }
  }

  class Son extends Father {

    void say() {
      try {
        MethodType mt = MethodType.methodType(void.class);
        MethodHandle mh = MethodHandles.lookup()
            .findSpecial(GrandFather.class, "say", mt, getClass());
        mh.invoke(this);
      } catch (Throwable throwable) {

      }
      System.out.println("i am son");
    }
  }

  public static void main(String[] args) {
    (new Test().new Son()).say();
  }
}
