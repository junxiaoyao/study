package niuke.test_multipart_sort;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.TreeSet;

/**
 * @Auther: jxy
 * @Date: 2019/12/5 19:45
 * @Description:主方法
 */
public class SortMainClass {

    public static void main(String[] args) throws Exception {
        TreeSet<ModelClass> treeSet = new TreeSet<>();
        PrintWriter writer = IOUtils.getFilePrint(IOUtils.FILE_RE);
        final String[] FILE_PATHS = new String[] {IOUtils.FILE_1, IOUtils.FILE_2, IOUtils.FILE_3};
        for (int i = 0; i < FILE_PATHS.length; i++) {
            BufferedReader reader = IOUtils.getFileReader(FILE_PATHS[i]);
            String line = reader.readLine();
            if (line != null && line.length() > 0) {
                String[] lines = line.split(",");
                ModelClass modelClass = new ModelClass(Integer.parseInt(lines[0]), lines[1], FILE_PATHS[i], reader);
                treeSet.add(modelClass);
            }
        }
        while (treeSet.size() > 0) {
            ModelClass modelClass = treeSet.first();
            writer.println(modelClass.getNum() + "," + modelClass.getData());
            treeSet.remove(modelClass);
            nextModel(modelClass, treeSet);
        }
        writer.close();
    }

    public static void nextModel(ModelClass modelClassSource, TreeSet<ModelClass> set) {
        try {
            BufferedReader reader = modelClassSource.getReader();
            String line = reader.readLine();
            if (line != null && line.length() > 0) {
                String[] lines = line.split(",");
                ModelClass modelClass =
                    new ModelClass(Integer.parseInt(lines[0]), lines[1], modelClassSource.getFileName(), reader);
                set.add(modelClass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
