package myblog.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @description
 * @author: jxy
 * @create: 2019-12-31 09:07
 */
public class ReadExcel {

    public static void main(String[] args) throws Exception {
        testRead(getInputStreamByPath("src/resource/tables.xlsx"));
    }

    public static InputStream getInputStreamByPath(String path) throws FileNotFoundException {
        return new FileInputStream(new File(path));
    }

    public static void testRead(InputStream in) throws Exception {
      Workbook wb=new XSSFWorkbook(in);
      Sheet sheet = wb.getSheetAt(0);
      System.in.read();
    }
}
