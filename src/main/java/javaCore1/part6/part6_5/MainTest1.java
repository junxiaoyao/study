package javaCore1.part6.part6_5;

import java.io.FileInputStream;
import java.io.Serializable;
import java.lang.reflect.Proxy;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import jvm.testInit.fieldInit.S;

public class MainTest1 {

  public static void main(String[] args) {
    InterfaceOner c = new InterfaceImp();
    ProxyManager manager = new ProxyManager(c);
    InterfaceOner o = (InterfaceOner) Proxy
        .newProxyInstance(c.getClass().getClassLoader(), c.getClass().getInterfaces(),
            manager);
    InterfaceOner o1 = (InterfaceOner) Proxy
        .newProxyInstance(c.getClass().getClassLoader(), c.getClass().getInterfaces(),
            new ProxyManager(c));
    //同样的类加载器、接口数组得到的是一个代理类
    System.out.println(o1.getClass() == o.getClass());
    Class o1Class = o1.getClass();
    System.out.println(Proxy.isProxyClass(o1Class));
    o.say();
    Stack stack=new Stack();
   // stack.pop();
    Logger logger=Logger.getLogger("ss");
    logger.setLevel(Level.INFO);
    logger.log(Level.WARNING,":ssdsd");
  }
}
