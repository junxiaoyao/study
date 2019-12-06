package niuke.test_multipart_sort;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Auther: jxy
 * @Date: 2019/12/5 20:12
 * @Description:
 */
public class TestData {

    public static void main(String[] args) {
         TreeSet<ModelClass> treeSet = new TreeSet<>();
      //   Map<String, Object> map = new HashMap<>();
         ModelClass modelClass = new ModelClass(1, "sdasc", "ssd", IOUtils.getFileReader(IOUtils.FILE_1));
         //ModelClass modelClass2 = new ModelClass(1, "sdasc", "ssd", IOUtils.getFileReader(IOUtils.FILE_1));
         treeSet.add(modelClass);
        // treeSet.add(modelClass2);
//         map.put("r1", modelClass);
//         map.put("r2", modelClass2);
       //  map.remove(modelClass);
         treeSet.remove(modelClass);
        TreeSet<TestRemove> treeSet2 = new TreeSet<>();
        TestRemove r1 = new TestRemove("sd", 5, new TestData(),IOUtils.getFileReader(IOUtils.FILE_1));
        treeSet2.add(r1);
        treeSet2.remove(r1);
      System.out.println();
    }
}

@AllArgsConstructor
@Data
class TestRemove implements Comparable<TestRemove> {

    private String str;

    private int code;

    private TestData testData;

    private BufferedReader bufferedReader;

    @Override
    public int compareTo(TestRemove o) {
        return o.getCode() - this.code;
    }
}
