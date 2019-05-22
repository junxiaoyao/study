package javaCore1.part8.fx;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ReflactFx {

  public static void main(String[] args) throws Exception {
    Class clazz = MainT.class;
    Method[] methods = clazz.getDeclaredMethods();
    Method method = clazz.getMethod("prints");
    Type type = method.getGenericReturnType();
    System.out.println(type.toString());
  }
}
