package nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description
 * @author: jxy
 * @create: 2019-08-27 09:37
 */
public class SimpleChannel {

    public static void main(String[] args)throws Exception {
        RandomAccessFile accessFile=new RandomAccessFile("src/resource/从前有座灵剑山.txt","rw");
        FileChannel inChannel=accessFile.getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(48);
        int bytesRead=inChannel.read(buffer);
        while (bytesRead!=-1){
            System.out.println("read:"+buffer);
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.print((char)buffer.get());
            }
            System.out.println();
            buffer.clear();
            bytesRead=inChannel.read(buffer);
        }
        accessFile.close();
    }
}
