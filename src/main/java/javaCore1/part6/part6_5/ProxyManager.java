package javaCore1.part6.part6_5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyManager implements InvocationHandler {

  private Object targetObject;

  public ProxyManager(Object targetObject) {
    this.targetObject = targetObject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("i am before method");
    return method.invoke(targetObject, args);
  }
}
