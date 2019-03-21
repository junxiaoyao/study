package mybatis.daos;
/*

import mybatis.annotations.MyInsertInto;
import mybatis.annotations.MyParam;
*/

import mybatis.annotations.MyInsertInto;
import mybatis.annotations.MyParam;

/**
 * @Auther: jxy
 * @Date: 2019/3/21 20:54
 * @Description:
 */

public interface NameDao {
    @MyInsertInto("insert into names(name,sex) values(#{name},#{sex})")
    int insert(@MyParam("name") String name, @MyParam("sex") String sex);
}
