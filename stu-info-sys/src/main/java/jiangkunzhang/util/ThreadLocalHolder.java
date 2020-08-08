package jiangkunzhang.util;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/7 20:54
 */
public class ThreadLocalHolder {
    private static ThreadLocal<Integer> TOTAL = new ThreadLocal<>();

    public static ThreadLocal<Integer> getTOTAL() {
        return TOTAL;
    }

}
