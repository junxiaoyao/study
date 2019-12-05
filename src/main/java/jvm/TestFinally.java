package jvm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @description
 * @author: jxy
 * @create: 2019-10-15 10:37
 */
public class TestFinally implements Serializable {
private int code=0;
    public static void main(String[] args)throws Exception {
        System.out.println(Integer.toOctalString(16));
        //getall();
        write("src/resource/txts.txt");
        read("src/resource/txts.txt");
    }
    public static void read(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream oisStream = new ObjectInputStream(new FileInputStream(filePath));
        TestFinally student = (TestFinally)oisStream.readObject();
        System.out.println(student.code);
    }
    public static void write(String filePath) throws IOException {
        ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(filePath));
        TestFinally student = new TestFinally();
        student.code=5;
        ooStream.writeObject(student);
        ooStream.close();
    }
    public static void getall() {
        try (BufferedReader isr = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter osw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String msgString = "";
            while (!msgString.equals("exit")) {
                msgString = isr.readLine();
                osw.write(msgString);
                osw.newLine();
                osw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
