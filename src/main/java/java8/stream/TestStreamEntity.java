package java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : porteryao
 * @description : 学习StreamApi 数据测试实体
 * @date : 2020/10/30 17:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestStreamEntity {

    private String userName;
    private String sex;
    private String createTime;
}
