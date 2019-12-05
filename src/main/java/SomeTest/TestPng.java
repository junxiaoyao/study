package SomeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;

/**
 * @description 测试png文件压缩功能
 * @author: jxy
 * @create: 2019-10-11 15:00
 */
public class TestPng {
    public static final int WIDTH=100;
    public static final int HEIGHT=100;
    public static void main(String[] args)throws Exception {
        readPic();
    }
    public static void readPic()throws Exception{

        File file=new File("src/resource/source.jpg");
        InputStream inputStream=new FileInputStream(file);
        String des="src/resource/thum_"+file.getName();
        //图片缩略图实现，强制按照指定的宽高进行缩略keepAspectRatio(false)
        Builder<? extends InputStream> thumbnail = Thumbnails.of(inputStream);
        thumbnail.size(WIDTH, HEIGHT);
        thumbnail.toFile(des);
        System.out.println();
    }
}
