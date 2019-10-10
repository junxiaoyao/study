package mybatis;

import mybatis.daos.*;
import mybatis.entity.Names;
import mybatis.proxy.SqlSessionManage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @Auther: jxy
 * @Date: 2019/3/21 21:22
 * @Description:
 */
public class TMain {

    public static void main(String[] args) throws Exception {
        // new BufferedReader(new FileInputStream(""));
        NameDao dao = SqlSessionManage.getDao(NameDao.class);
        /*  Names name = dao.getById(7l);*/
        List<Names> list = dao.getByName("瞎写，");
        List<Names> allList = dao.getAll();
        int deleteRow = dao.delete(list.get(0).getId());
        list = dao.getByName("瞎写，");
        int row = dao.insert("瞎写，", "哪买的");
        /*   dao.delete(7l);
        Names name2 = dao.getById(1l);
        int row = dao.update("我改了7", "性别7", 7l);
        Names name32 = dao.getById(7l);*/
        System.out.println();
    }
}
