package jiangkunzhang.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/26 11:59
 */
public class JSONUtilTest {

    @Test
    public void testWrite() {
        Map<String, String> map = new HashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","d");
        String s = JSONUtil.write(map);
        System.out.println(s);
        Assert.assertNotNull(s);
    }

    @Test
    public void testRead() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("test.json");
        HashMap<String, String> map = JSONUtil.read(is, HashMap.class);
        System.out.println(map);
        Assert.assertNotNull(map);
    }
}
