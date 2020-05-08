package thread.concurrent_study.testWaiAndNotify;

import java.util.ArrayList;
import java.util.List;

public class MainTestWaitAndNotify {
    public static void main(String[] args) {
        TargetClass t=new TargetClass();
        new Thread(new GetRunnable(t)).start();
       // new Thread(new GetRunnable(t)).start();
        new Thread(new SetRunnable(t)).start();
    }
}

class GetRunnable implements Runnable {
    private TargetClass targetClass;

    public GetRunnable(TargetClass targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public void run() {
        try {
            System.out.println(targetClass.getFirstElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class SetRunnable implements Runnable {
    private TargetClass targetClass;

    public SetRunnable(TargetClass targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public void run() {
        try {

            for(int i=0;i<5;i++){
                Thread.sleep(2000);
                targetClass.addElement(5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class TargetClass {
    List<Integer> list = new ArrayList<>();

    public synchronized int getFirstElement() throws InterruptedException {
        System.out.println("开始获取链表数据了");
        while (list.size() < 5) {
            System.out.println("------------wait--------------");
            wait();
        }
        return list.size();
    }

    public synchronized boolean addElement(int num) throws InterruptedException {
        boolean bool = list.add(num);
        notifyAll();
        return bool;
    }
}