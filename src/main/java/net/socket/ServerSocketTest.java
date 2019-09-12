package net.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description
 * @author: jxy
 * @create: 2019-07-12 15:47
 */
public class ServerSocketTest {

    public static void main(String[] args) throws Exception {
        simpeSocketServer();
    }

    public static void simpeSocketServer() throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端监听8888端口，等待连接");
        Socket socket = serverSocket.accept();
        Scanner scanner = new Scanner(System.in);
        Runnable readRunnable= SocketUtil.getReceiveRunnable(socket, "客户端");
        Runnable sendRunnable = SocketUtil.getSendMegRunnable(socket, scanner);
        new Thread(readRunnable).start();
        new Thread(sendRunnable).start();
        while (Thread.activeCount() > 1) {
            Thread.sleep(1000);
        }
        serverSocket.close();
    }
}
