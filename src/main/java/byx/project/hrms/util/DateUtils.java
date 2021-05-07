package byx.project.hrms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 日期工具类
 *
 * @author byx
 */
public class DateUtils {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取当前日期的字符串形式
     */
    public static String now() {
        Calendar calendar = Calendar.getInstance();
        return FORMAT.format(calendar.getTime());
    }
}
