package niuke.test_multipart_sort;

import java.io.*;

/**
 * @Auther: jxy
 * @Date: 2019/12/5 19:20
 * @Description:
 */
public class IOUtils {
    public final static String FILE_PATH_PREFIX = "src/resource/";
    public final static String FILE_1 = "F1.txt";
    public final static String FILE_2 = "F2.txt";
    public final static String FILE_3 = "F3.txt";
    public final static String FILE_RE = "RE.txt";
    public static void main(String[] args) throws Exception{
         writeFile(FILE_3,5);
       // testReadFile(FILE_1);
    }

    public static void testReadFile(String fileName)throws Exception {
        BufferedReader reader=getFileReader(fileName);
        String line=null;
        while ((line=reader.readLine())!=null){
            System.out.println(line);
        }
    }
    //文件名+随机因子参数文件随机数据
    public static void writeFile(String fileName,int randomInt) {
        PrintWriter pw = getFilePrint(fileName);
        int baseNum = 2;
        for (int i = 0; i < 5; i++) {
            String str = baseNum + ",数据段模拟数据"+fileName;
            baseNum = baseNum + (int) (Math.random() * randomInt);
            pw.println(str);
        }

        pw.close();
    }

    public static BufferedReader getFileReader(String fileName) {
        BufferedReader bufferedReader = null;
        try {
            File file = new File(FILE_PATH_PREFIX + fileName);
            Reader reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
        } catch (Exception e) {
            return null;
        }
        return bufferedReader;
    }

    //得到输出器
    public static PrintWriter getFilePrint(String fileName) {
        PrintWriter printWriter = null;
        try {
            File file = new File(FILE_PATH_PREFIX + fileName);
            Writer writer = new FileWriter(file);
            printWriter = new PrintWriter(writer);
        } catch (Exception e) {
            return null;
        }
        return printWriter;
    }
}
