package mybatis.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: jxy
 * @Date: 2019/3/22 10:39
 * @Description:
 */
public class SqlUtil {

    //返回sql
    public static String getParameter(String sql, Map<String, Integer> map) {
        int count = 1;
        String sqlC = sql;
        int firstC = sql.indexOf("#{");
        int lastC = sql.indexOf("}");
        while (firstC > 0 && lastC > 0) {
            String parameter = sql.substring(firstC + 2, lastC);
            map.put(parameter, count++);
            sqlC = sqlModify(sqlC, parameter);
            sql = sql.substring(lastC + 1);
            firstC = sql.indexOf("#{");
            lastC = sql.indexOf("}");
        }
        return sqlC;
    }

    //替换参数为问号
    public static String sqlModify(String sql, String parameter) {
        String REGEX = "#\\{" + parameter + "}";
        final String REPLACE = "?";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(sql);
        sql = m.replaceAll(REPLACE);
        System.out.println(sql);
        return sql;
    }

    //执行新增操作
    public static int insertIntoUtil(Connection connection, String sql, ArrayList args) throws SQLException {
        PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(sql);
        pstmt.setString(1, connection.toString());
        java.util.Date date = Calendar.getInstance().getTime();
        pstmt.setDate(2, new Date(date.getYear(), date.getMonth(), date.getDay()));
        pstmt.executeUpdate();
        pstmt.close();
        return 1;
    }
}
