package jiangkunzhang.util;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/26 11:04
 */
public class DBUtil {
    private static final String URL= "jdbc:mysql://localhost:3306/stu_info?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "0331";

    private static volatile DataSource DS;
    private DBUtil() {}
    private static DataSource getDataSource() {
        if (DS == null) {
            synchronized (DBUtil.class) {
                if (DS == null) {
                    DS = new MysqlDataSource();
                    ((MysqlDataSource) DS).setUrl(URL);
                    ((MysqlDataSource) DS).setUser(USER);
                    ((MysqlDataSource) DS).setPassword(PASSWORD);
                }
            }
        }
        return DS;
    }

    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败",e);
        }
    }

    public static void close(Connection c, Statement s) {
        close(c,s,null);
    }

    public static void close(Connection c, Statement s, ResultSet r) {
        try {
            if (c != null) {
                c.close();
            }
            if (s != null) {
                s.close();
            }
            if (r != null) {
                r.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("释放数据库资源出错",e);
        }
    }
}
