package javaCore1.part14.part14_5;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduleExecute {

  public static void main(String[] args) {
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
    executorService.scheduleAtFixedRate(new TestScheduleExecuteRunable(), 5l, 5l, TimeUnit.SECONDS);
  }
}

class TestScheduleExecuteRunable implements Runnable {

  @Override
  public void run() {
    System.out.println("我被调用了：" + Calendar.getInstance().getTime().getTime());
  }
}