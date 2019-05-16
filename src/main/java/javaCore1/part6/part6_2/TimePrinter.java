package javaCore1.part6.part6_2;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimePrinter implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("at the tone,the time is "+new Date());
    Toolkit.getDefaultToolkit().beep();
  }
}
