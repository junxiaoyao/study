package netstudy.center.iopart;

import java.io.File;
import java.util.List;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-10 16:19
 */
public class FileTest1 {

  public static void main(String[] args) {

    File file = new File("F:\\ss");
    blFile(file);
  }

  public static void blFile(File file) {
    //System.out.println("is dirs :" + file.isDirectory());
    //以文件数组的形式，返回当前文件夹下的所有文件(夹)（不包含子文件及子文件夹）
    File[] sonFileList = file.listFiles();
    printFile(sonFileList);
  }

  public static void printFile(File... files){
    for (int i = 0; i < files.length; i++) {
      if (files[i].isDirectory())
        blFile(files[i]);
      else {
        System.out.println("file name: "+files[i].getName());
      }
    }
  }
}
