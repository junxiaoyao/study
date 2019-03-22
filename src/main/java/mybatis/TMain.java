package mybatis;

import mybatis.daos.*;
import mybatis.entity.Names;
import mybatis.proxy.SqlSessionManage;

import java.util.List;

/**
 * @Auther: jxy
 * @Date: 2019/3/21 21:22
 * @Description:
 */
public class TMain {
    public static void main(String[] args) {
        NameDao dao = SqlSessionManage.getDao(NameDao.class);
        Names name = dao.getById(6l);
        List<Names> list = dao.getByName("nameTest");
        System.out.println();
    }
}
