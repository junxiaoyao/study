package niuke.test_multipart_sort;

import java.io.BufferedReader;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Auther: jxy
 * @Date: 2019/12/5 19:24
 * @Description:
 */
@Data
@AllArgsConstructor
public class ModelClass implements Comparable<ModelClass> {

    private int num;

    private String data;

    private String fileName;

    private BufferedReader reader;

    @Override
    public int compareTo(ModelClass o) {
        if (o.getReader()==this.reader) {
            return 0;
        }
        int od = this.num - o.getNum();
        return od != 0 ? od : -1;
    }
}
