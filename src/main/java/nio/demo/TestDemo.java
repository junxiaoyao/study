package nio.demo;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import javaCore1.threePart.T;

/**
 * @description
 * @author: jxy
 * @create: 2019-11-29 10:22
 */
public class TestDemo {

    public static void main(String[] args) throws Exception {
        TestDemo demo = new TestDemo();
        InputStream inputStream = demo.getClass().getClassLoader().getResourceAsStream("从前有座灵剑山.txt");
        String filepath = demo.getClass().getClassLoader().getResource("").getPath() + "从前有座灵剑山1.txt";
        System.out.println(readFileToString(filepath, Charset.forName("utf-8")));
    }

    public static String readFileToString(String filepath, Charset charset) throws IOException {
        try (FileInputStream in = new FileInputStream(filepath); FileChannel channel = in.getChannel()) {
            long fileSize = channel.size();
            int bufferSize = 1024;
            if (fileSize < 1024) {
                bufferSize = (int) fileSize;
            }
            StringBuilder builder = new StringBuilder((int) (fileSize / 2));
            ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
            CharBuffer charBuffer = CharBuffer.allocate(bufferSize / 2);
            CharsetDecoder decoder = charset.newDecoder();
            while (channel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                CoderResult rel;
                do {
                    rel = decoder.decode(byteBuffer, charBuffer, false);
                    charBuffer.flip();
                    builder.append(charBuffer.array(), 0, charBuffer.limit());
                    charBuffer.clear();
                } while (rel.isOverflow());
                byteBuffer.compact();
            }
            byteBuffer.flip();
            decoder.decode(byteBuffer, charBuffer, true);
            charBuffer.flip();
            builder.append(charBuffer.array(), 0, charBuffer.limit());
            charBuffer.clear();
            return builder.toString();
        }
    }
}
