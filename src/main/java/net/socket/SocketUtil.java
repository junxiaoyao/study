package net.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description
 * @author: jxy
 * @create: 2019-07-12 16:09
 */
public class SocketUtil {

    public static Runnable getReceiveRunnable(Socket socket, String type) {
        ReadRunnable readRunnable = new ReadRunnable(socket, type);
        return readRunnable;
    }

    public static Runnable getSendMegRunnable(Socket socket, Scanner scanner) {
        return new WriteRunnable(socket, scanner);
    }

}

class ReadRunnable implements Runnable {

    Socket socket;

    String type;

    String read = "";

    public ReadRunnable(Socket socket, String type) {
        this.socket = socket;
        this.type = type;
    }

    @Override public void run() {
        System.out.println("-------------我是读线程------------");
        try {
            while (!read.equals("end")) {
                System.out.println("-------------------------");
                InputStream in = socket.getInputStream();
                DataInputStream dis = new DataInputStream(in);
                System.out.println(type + ":"+dis.readUTF());
                System.out.println("-------------------------");
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class WriteRunnable implements Runnable {

    Socket socket;

    Scanner scanner;

    String send = "";

    public WriteRunnable(Socket socket, Scanner scanner) {
        this.socket = socket;
        this.scanner = scanner;
    }

    @Override public void run() {
        try {
            System.out.println("-------------我是写线程------------");
            while (!send.equals("end")) {
                System.out.println("-------------------------");
                System.out.println("请输入：");
                send = scanner.nextLine();
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(send);
                System.out.println("-------------------------");
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}