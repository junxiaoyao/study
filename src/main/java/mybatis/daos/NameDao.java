package mybatis.daos;
/*

import mybatis.annotations.MyInsertInto;
import mybatis.annotations.MyParam;
*/

import mybatis.annotations.MyInsertInto;
import mybatis.annotations.MyParam;
import mybatis.annotations.MySelect;
import mybatis.entity.Names;

import java.util.List;

/**
 * @Auther: jxy
 * @Date: 2019/3/21 20:54
 * @Description:
 */

public interface NameDao {
    @MyInsertInto("insert into names(name,sex) values(#{name},#{sex})")
    int insert(@MyParam("name") String name, @MyParam("sex") String sex);

    @MySelect("select * from names WHERE id=#{id}")
    Names getById(@MyParam("id") long id);

    @MySelect("select * from names WHERE name=#{name}")
    List<Names> getByName(@MyParam("name") String name);

}
