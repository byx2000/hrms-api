package byx.project.hrms.controller;

import byx.project.hrms.common.Result;
import byx.project.hrms.pojo.vo.AttendanceReportVO;
import byx.project.hrms.service.AttendanceReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 考勤报表控制器
 *
 * @author byx
 */
@RestController
@RequestMapping("/report/attendance")
public class AttendanceReportController {
    @Autowired
    private AttendanceReportService attendanceReportService;

    /**
     * 获取最近一个月考勤报表
     */
    @PostMapping("/latest-month")
    public Result<List<AttendanceReportVO>> latestMonth() {
        return Result.success(attendanceReportService.getLatestMonthAttendanceReport());
    }
}
