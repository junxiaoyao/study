package javaCore1.part6.part6_2.part6_3_3;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Timer;

public class Mt {

  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("sdsd");
    list.add(null);
    String[] strings={"asdsd","21","5","sa"};
    Arrays.sort(strings,String::compareTo);
    System.out.println(Arrays.deepToString(strings));
    System.out.println(list.size());
    list.removeIf(e -> e == null);
    System.out.println(list.size());
    System.out.println();
//    Object o=Math::pow();
    //show("s",5);
    new Thread(new Runnable() {
      @Override
      public void run() {
       Mt.show("ss",100);
      }
    }).start();
  }
  public static void show(String text,int count){
    System.out.println("s");
    for (int i=0;i<count;i++){
      ActionListener actionListener=e -> {
        System.out.println(" "+text);
      };
      new Timer(10,actionListener).start();
    }
  }
}
