package jiangkunzhang.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/26 11:24
 */
public class DBUtilTest {
    @Test
    public void testConnection() {Assert.assertNotNull(DBUtil.getConnection());}
}
