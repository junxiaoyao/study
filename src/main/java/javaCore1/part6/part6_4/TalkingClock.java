package javaCore1.part6.part6_4;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;

public class TalkingClock {

  private int interval;
  private boolean boop;

  public TalkingClock(int interval, boolean boop) {
    this.interval = interval;
    this.boop = boop;
  }

  public void start(int time,boolean bool) {
    //局部内部类
    class TimePrinter2 implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("TimePrinter2,the time is:" + new Date());
        if (bool) {
          Toolkit.getDefaultToolkit().beep();
        }
      }
    }
    Timer timer = new Timer(time, new TimePrinter2());
    timer.start();
  }
  public void start() {
    Timer timer = new Timer(interval, new TimePrinter());
    timer.start();
  }

  public class TimePrinter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("TimePrinter,the time is:" + new Date());
      if (boop) {
        Toolkit.getDefaultToolkit().beep();
      }
    }
  }

  public static void main(String[] args) {
    while (true) {
     // new TalkingClock(50, false).start();
      new TalkingClock(50, false).start(50,true);
    }
  }
}
