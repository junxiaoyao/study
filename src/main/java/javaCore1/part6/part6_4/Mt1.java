package javaCore1.part6.part6_4;

public class Mt1 {

  public static void main(String[] args) {
    System.out.println("--------------------------------");
    System.out.println(new Object(){}.getClass().getEnclosingClass());
    System.out.println(TalkingClock.TimePrinter.class.getSimpleName());
    //TalkingClock.TimePrinter timePrinter=new TalkingClock(500,false).new TimePrinter();
  }
}
