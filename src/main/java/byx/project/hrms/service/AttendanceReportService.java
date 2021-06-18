package byx.project.hrms.service;

import byx.project.hrms.pojo.vo.AttendanceReportVO;

import java.util.List;

/**
 * 考勤报表服务接口
 *
 * @author byx
 */
public interface AttendanceReportService {
    /**
     * 获取最近一个月的考勤报表
     */
    List<AttendanceReportVO> getLatestMonthAttendanceReport();
}
