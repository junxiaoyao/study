package work;

/**
 * @description
 * @author: jxy
 * @create: 2020-05-14 10:11
 */
public class Test {

  public static void main(String[] args) {
    boolean isOk = false;

    assert 1>2;//如果开启则会调用assert，那么isOk就为true

    System.out.println(isOk);//
  }
}
