package net.testURl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description
 * @author: jxy
 * @create: 2019-07-12 15:12
 */
public class MainTest_01 {

    public static void main(String[] args) throws Exception {
       // System.out.println(commandTest("10.10.33.254"));
        testInuserIp();
    }

    //获取Ip
    public static void showIp() throws Exception {
        InetAddress host = InetAddress.getLocalHost();
        System.out.println(host.getHostAddress());
    }

    public static void testInuserIp()throws InterruptedException {
        List<String> ipList = new CopyOnWriteArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch latch=new CountDownLatch(10);
        //10.10.33
        String ipPrefix="10.10.33.";
        for (int i=1;i<11;i++){
            TestIpCanuser canuser=new TestIpCanuser(ipList,ipPrefix+i,latch);
            service.execute(canuser);
        }
        latch.await();
        for (String ip:ipList){
            System.out.println(ip);
        }
    }

    //ping
    public static String commandTest(String ip) throws IOException {
        Process process = Runtime.getRuntime().exec("ping " + ip);
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "GB2312"));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.length() != 0) {
                sb.append(line + "\r\n");
            }
        }
        return sb.toString();
    }

}

class TestIpCanuser implements Runnable {

    private List<String> list;

    private String ip;

    private CountDownLatch latch;
    public TestIpCanuser(List<String> list, String ip,CountDownLatch latch) {
        this.list = list;
        this.ip = ip;
        this.latch=latch;
    }

    @Override public void run() {
        try {
            String result = MainTest_01.commandTest(ip);
            if (result.indexOf("丢失 = 0") != -1) {
                list.add(ip);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            latch.countDown();
        }

    }
}