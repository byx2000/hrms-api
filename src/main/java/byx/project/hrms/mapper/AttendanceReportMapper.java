package byx.project.hrms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 考勤报表数据访问接口
 *
 * @author byx
 */
@Mapper
public interface AttendanceReportMapper {
    /**
     * 获取指定日期正常考勤的人数
     */
    @Select("""
            select count(0) from
            (select empId from attendance
            where date = #{date}
            and ((type = 0 and time <= '09:00') or (type = 1 and time >= '17:00'))
            group by empId
            having count(0) = 2) t""")
    Integer getNormalCount(String date);

    /**
     * 获取指定日期迟到的人数
     */
    @Select("""
            select count(0) from attendance
            where date = #{date}
            and type = 0 and time > '09:00'""")
    Integer getArriveLateCount(String date);

    /**
     * 获取指定日期早退的人数
     */
    @Select("""
            select count(0) from attendance
            where date = #{date}
            and type = 1 and time < '17:00'""")
    Integer getLeaveEarlyCount(String date);
}
