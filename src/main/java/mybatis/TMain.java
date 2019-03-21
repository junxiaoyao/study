package mybatis;
import mybatis.daos.*;
import mybatis.proxy.SqlSessionManage;

/**
 * @Auther: jxy
 * @Date: 2019/3/21 21:22
 * @Description:
 */
public class TMain {
    public static void main(String[] args) {
        NameDao dao= SqlSessionManage.getDao(NameDao.class);
        dao.insert("s","s");
    }
}
