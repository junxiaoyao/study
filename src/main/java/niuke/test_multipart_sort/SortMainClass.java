package niuke.test_multipart_sort;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Auther: jxy
 * @Date: 2019/12/5 19:45
 * @Description:
 */
public class SortMainClass {
    public static void main(String[] args) throws Exception {
        List<ModelClass> list = new ArrayList<>();
        TreeSet<ModelClass> treeSet = new TreeSet<>();
        BufferedReader r_1 = IOUtils.getFileReader(IOUtils.FILE_1);
        PrintWriter writer = IOUtils.getFilePrint(IOUtils.FILE_RE);
        String line_1 = r_1.readLine();
        if (line_1 != null && line_1.length() > 0) {
            String[] line_1s = line_1.split(",");
            ModelClass modelClass = new ModelClass(Integer.parseInt(line_1s[0]), line_1s[1], IOUtils.FILE_1);
            treeSet.add(modelClass);
        }

        BufferedReader r_2 = IOUtils.getFileReader(IOUtils.FILE_2);
        String line_2 = r_2.readLine();
        if (line_2 != null && line_2.length() > 0) {
            String[] line_2s = line_2.split(",");
            ModelClass modelClass = new ModelClass(Integer.parseInt(line_2s[0]), line_2s[1], IOUtils.FILE_2);
            treeSet.add(modelClass);
        }

        BufferedReader r_3 = IOUtils.getFileReader(IOUtils.FILE_3);
        String line_3 = r_3.readLine();
        if (line_3 != null && line_3.length() > 0) {
            String[] line_3s = line_3.split(",");
            ModelClass modelClass = new ModelClass(Integer.parseInt(line_3s[0]), line_3s[1], IOUtils.FILE_3);
            treeSet.add(modelClass);
        }
        while (treeSet.size() > 0) {
            ModelClass modelClass = treeSet.first();
            list.add(modelClass);
            writer.println(modelClass.getNum()+","+modelClass.getData());
            treeSet.remove(modelClass);
            String fileName = modelClass.getFileName();
            switch (fileName) {
                case IOUtils.FILE_1:
                    nextModel(r_1, modelClass, treeSet);
                    break;
                case IOUtils.FILE_2:
                    nextModel(r_2, modelClass, treeSet);
                    break;
                case IOUtils.FILE_3:
                    nextModel(r_3, modelClass, treeSet);
                    break;
            }

        }
        writer.close();
        //System.out.println();
    }

    public static boolean nextModel(BufferedReader reader, ModelClass modelClassSource, TreeSet<ModelClass> set) {
        try {
            String line = reader.readLine();
            if (line != null && line.length() > 0) {
                String[] lines = line.split(",");
                ModelClass modelClass = new ModelClass(Integer.parseInt(lines[0]), lines[1], modelClassSource.getFileName());
                set.add(modelClass);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
