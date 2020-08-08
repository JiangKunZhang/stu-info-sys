package jiangkunzhang.dao;

import jiangkunzhang.model.Classes;
import jiangkunzhang.model.Student;
import jiangkunzhang.model.User;
import jiangkunzhang.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/2 11:47
 */
public class UserDAO {
    public static User query(User u) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User query = null;

        try {
            //获取数据库连接
            c = DBUtil.getConnection();
            String sql = "select id, nickname, email, create_time from user where username=? and password=?";
            //创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            //执行sql语句
            rs = ps.executeQuery();
            while (rs.next()) {
                query = u;
                query.setId(rs.getInt("id"));
                query.setNickname(rs.getString("nickname"));
                query.setEmail(rs.getString("email"));
                query.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
            }
            return query;
        } catch (Exception e) {
            throw new RuntimeException("登录校验用户名密码出错",e);
        } finally {
            DBUtil.close(c, ps, rs);
        }
    }
}
