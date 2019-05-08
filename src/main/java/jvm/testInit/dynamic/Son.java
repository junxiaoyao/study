package jvm.testInit.dynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class Son extends Father {

  public void say() {
    try {
      MethodType mt = MethodType.methodType(void.class);
      MethodHandle mh = MethodHandles.lookup()
          .findSpecial(GrandFather.class, "say", mt, getClass());
      mh.invoke(this);
    } catch (Throwable e) {
      e.printStackTrace();
    }
    System.out.println("i am son");
  }
}
