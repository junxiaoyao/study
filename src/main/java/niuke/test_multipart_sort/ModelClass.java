package niuke.test_multipart_sort;

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

    @Override
    public int compareTo(ModelClass o) {
        int od = this.num - o.getNum();
        if (od == 0) {
            if (this.getFileName().equals(o.getFileName())) {
                return 0;
            } else {
                return -1;
            }
        }
        return this.num - o.getNum();
    }
}
