package javaCore1.part14.part14_5;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduleExecute {

  public static void main(String[] args) {
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
    //runable，首次执行延迟时间，以后执行延迟时间，时间单位
    executorService.scheduleAtFixedRate(new TestScheduleExecuteRunable(), 5l, 3l, TimeUnit.SECONDS);
  }
}

class TestScheduleExecuteRunable implements Runnable {
  private volatile int size=1;
  @Override
  public void run() {
    System.out.println("我被调用了：" +size+++" 次，时间:"+ Calendar.getInstance().getTime());
  }
}