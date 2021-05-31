package byx.project.hrms.controller;

import byx.project.hrms.common.Result;
import byx.project.hrms.pojo.dto.AttendanceListQueryDTO;
import byx.project.hrms.pojo.dto.LatestWeekAttendanceQueryDTO;
import byx.project.hrms.pojo.vo.AttendanceListItemVO;
import byx.project.hrms.pojo.vo.LatestWeekAttendanceItemVO;
import byx.project.hrms.service.AttendanceService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 考勤控制器
 *
 * @author byx
 */
@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    /**
     * 获取考勤列表
     */
    @PostMapping("/list")
    public Result<PageInfo<AttendanceListItemVO>> list(@RequestBody @Validated AttendanceListQueryDTO dto) {
        return Result.success(attendanceService.getAttendanceList(dto));
    }

    /**
     * 获取最近一周考勤列
     */
    @PostMapping("/latest-week")
    public Result<List<LatestWeekAttendanceItemVO>> listOfLatestWeek(@RequestBody @Validated LatestWeekAttendanceQueryDTO dto) {
        return Result.success(attendanceService.getLatestWeekAttendance(dto));
    }
}
