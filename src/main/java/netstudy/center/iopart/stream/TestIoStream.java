package netstudy.center.iopart.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-10 16:39
 */
public class TestIoStream {

  public static void main(String[] args) throws Exception {
//    for (int i=1;i<9000;i++){
//      File f2=new File("F://从前有座灵剑山"+i+".txt");
//      if (f2.exists()){
//        System.out.println("准备删除："+i);
//        f2.delete();
//      }
//    }
    File file = new File("F:\\javaFile\\从前有座灵剑山.txt");
    FileInputStream in = new FileInputStream(file);

    byte[] bytes = new byte[1024*1024];
    int count=1;
    while (in.read(bytes)!=-1){
     // System.out.println(bytes.toString());
      File f2=new File("F:\\javaFile\\从前有座灵剑山"+count+++".txt");
      FileOutputStream out=new FileOutputStream(f2);
      out.write(bytes);
    }

  }
}
