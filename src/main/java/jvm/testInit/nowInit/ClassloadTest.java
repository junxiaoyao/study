package jvm.testInit.nowInit;

import java.io.IOException;
import java.io.InputStream;

public class ClassloadTest {

  public static Class getClassByName(String name) throws ClassNotFoundException {
    ClassLoader classLoader = new ClassLoader() {
      @Override
      public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
          String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
          InputStream is = getClass().getResourceAsStream(fileName);
          if (is == null) {
            return super.loadClass(name);
          }
          byte[] bytes = new byte[is.available()];
          is.read(bytes);
          return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
          throw new ClassNotFoundException(name);
        }
      }
    };
    return classLoader.loadClass(name);
  }
}
