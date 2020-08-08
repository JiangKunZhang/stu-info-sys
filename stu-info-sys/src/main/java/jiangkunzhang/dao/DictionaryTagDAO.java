package jiangkunzhang.dao;

import jiangkunzhang.model.DictionaryTag;
import jiangkunzhang.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/31 19:43
 */
public class DictionaryTagDAO {

    public static List<DictionaryTag> query(String key) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DictionaryTag> tags = new ArrayList<>();

        try {
            c = DBUtil.getConnection();
            String sql = "select concat(d.dictionary_key, dt.dictionary_tag_key) dictionary_tag_key," +
                    "       dt.dictionary_tag_value" +
                    "   from dictionary d" +
                    "         join dictionary_tag dt on d.id = dt.dictionary_id" +
                    "   where d.dictionary_key = ?";
            ps = c.prepareStatement(sql);
            ps.setString(1, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                DictionaryTag tag = new DictionaryTag();
                tag.setDictionaryTagKey(rs.getString("dictionary_tag_key"));
                tag.setDictionaryTagValue(rs.getString("dictionary_tag_value"));
                tags.add(tag);
            }
            return tags;
        } catch (Exception e) {
            throw new RuntimeException("查询数据字典标签出错",e);
        } finally {
            DBUtil.close(c, ps, rs);
        }
    }
}
