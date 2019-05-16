package javaCore1.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class Maint {

  public static void main(String[] args) {
    Sub sub=new Sub();
    System.out.println(sub.sex);
    Class<?> clazz = Sub.class;
    Method[] methods = clazz.getDeclaredMethods();
    Field[] fields = clazz.getDeclaredFields();
    int[] nums = {1, 32, 62, 6, 6, 26, 22, 1, 31, 3, 1};
    int[] nums2=(int[]) copyArray(nums,20);

    System.out.println(Array.get(nums, 6));
    for (Method method : methods) {
      Parameter[] parameters = method.getParameters();
      for (Parameter parameter : parameters) {
        System.out.println("参数：" + parameter.getType().getSimpleName() + " " + parameter.getName());
      }
      System.out.println(method.getName() + "  " + Modifier.toString(method.getModifiers()));
    }
    for (Field field : fields) {
      System.out.println(field.getName() + "  " + Modifier.toString(field.getModifiers()));
    }
  }

  /**
   * 可以扩容泛型数组
   */
  public static Object copyArray(Object o, int newLength) {
    Class cl = o.getClass();
    if (!cl.isArray()) {
      return null;
    }
    Class componentType = cl.getComponentType();
    int length = Array.getLength(o);
    Object newArray = Array.newInstance(componentType, newLength);
    System.arraycopy(o, 0, newArray, 0, length);
    return newArray;
  }
}
