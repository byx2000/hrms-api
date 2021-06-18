package byx.project.hrms.util;

import byx.project.hrms.common.Status;
import byx.project.hrms.exception.BizException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    /**
     * 将字符串转换成Date对象
     */
    public static Date toDate(String date) {
        try {
            return FORMAT.parse(date);
        } catch (ParseException e) {
            throw new BizException(Status.INTERNAL_ERROR, "日期格式转换错误");
        }
    }

    /**
     * 将Date对象转换成字符串
     */
    public static String toString(Date date) {
        return FORMAT.format(date);
    }
}
