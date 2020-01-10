package net.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @description
 * @author: jxy
 * @create: 2019-07-12 15:51
 */
public class SocketClientTest {

    public static void main(String[] args) throws Exception {
        simpleClient();
    }

    public static void simpleClient() throws IOException {
        //连接到本机的8888端口
        Socket s = new Socket("127.0.0.1", 8888);
        Scanner scanner = new Scanner(System.in);
        Runnable readRunnable = SocketUtil.getReceiveRunnable(s, "服务端");
        Runnable sendRunnable = SocketUtil.getSendMegRunnable(s, scanner);
        new Thread(readRunnable).start();
        new Thread(sendRunnable).start();
    }
}
