package nio.mytest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @description
 * @author: jxy
 * @create: 2019-11-29 15:34
 */
public class MyFirstNio {

    public static void main(String[] args) throws Exception {
        MyFirstNio nio = new MyFirstNio();
        String fileInPath = nio.getClass().getClassLoader().getResource("").getPath() + "从前有座灵剑山.txt";
        String fileOutPath = nio.getClass().getClassLoader().getResource("").getPath() + "从前有座灵剑山out.txt";
      //  copyByNio(fileInPath, fileOutPath);
        System.out.println(readByNio(fileInPath));
    }

    // 通过Nio方式复制文件
    public static void copyByNio(String fileInPath, String fileOutPath) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(fileInPath);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutPath);
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();
        // CharBuffer buffer = CharBuffer.allocate(1024);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            // 清空缓冲区，将其改为写状态
            byteBuffer.clear();
            // 从输入管道读入数据到缓冲区
            int length = fileInputStreamChannel.read(byteBuffer);
            if (length < 0) {
                break;
            }
            // 转化为读方法
            byteBuffer.flip();
            // 从缓冲区读取并写入输出管道
            fileOutputStreamChannel.write(byteBuffer);
        }
        fileInputStreamChannel.close();
        fileOutputStreamChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static String readByNio(String fileInPath) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(fileInPath);
        FileChannel channel = fileInputStream.getChannel();
        int size=1024;
        if (channel.size()<1024){
            size=(int)channel.size();
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(size);
        CharBuffer charBuffer = CharBuffer.allocate(size/2);
        StringBuilder builder = new StringBuilder();
        Charset charset=Charset.forName("utf-8");
        CharsetDecoder decoder = charset.newDecoder();
        while (true) {
            charBuffer.clear();
            byteBuffer.clear();
            int length=channel.read(byteBuffer);
            decoder.decode(byteBuffer,charBuffer,false);
            charBuffer.flip();
            builder.append(charBuffer.array(), 0, charBuffer.limit());
            break;
        }
        charBuffer.flip();
        builder.append(charBuffer.array(), 0, charBuffer.limit());
        return builder.toString();
    }
}
