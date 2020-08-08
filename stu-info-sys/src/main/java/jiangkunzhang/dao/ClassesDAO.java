package jiangkunzhang.dao;

import jiangkunzhang.model.Classes;
import jiangkunzhang.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/2 10:13
 */
public class ClassesDAO {

    public static List<Classes> queryAsDict() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Classes> tags = new ArrayList<>();

        try {
            c = DBUtil.getConnection();
            String sql = "select id, classes_name, classes_graduate_year, classes_major from classes";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Classes classes = new Classes();
                classes.setDictionaryTagKey(String.valueOf(rs.getInt("id")));
                classes.setDictionaryTagValue(rs.getString("classes_name"));
                classes.setClassesGraduateYear(rs.getString("classes_graduate_year"));
                classes.setClassesMajor(rs.getString("classes_major"));
                tags.add(classes);
            }
            return tags;
        } catch (Exception e) {
            throw new RuntimeException("查询班级数据字典出错", e);
        } finally {
            DBUtil.close(c, ps, rs);
        }
    }
}
