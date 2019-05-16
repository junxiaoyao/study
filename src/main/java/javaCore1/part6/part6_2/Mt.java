package javaCore1.part6.part6_2;


import javax.swing.Timer;

public class Mt {

  public static void main(String[] args) {
    TimePrinter r = new TimePrinter();
    while (true) {
      Timer t = new Timer(10000, r);
      t.start();
    }
    // Thread.sleep(2000);
   // JOptionPane.showMessageDialog(null, "quit");
  //  System.exit(0);
  }
}
