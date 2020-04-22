package thread;

/**
 * @description
 * @author: jxy
 * @create: 2020-04-14 11:18
 */
public class TestException {

  public static void main(String[] args) {
    int intNum=5;
    float s=5.0f;
    Double b1=new Double(intNum);
    Double b2=new Double(s);
    if (s-intNum<Double.MIN_VALUE){
      System.out.println("sdsd");
    }
    System.out.println(b1.compareTo(b2));
    for (int i=0;i<5;i++){
      new Thread(()->{
        try {
          String str=null;
          str.toString();
        }catch (Exception e){
          System.out.println(e.hashCode());
          System.out.println("=======================");
          System.out.println();
        }
      });
    }
  }

}
