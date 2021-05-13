package byx.project.hrms.service;

import byx.project.hrms.pojo.dto.AttendanceListQueryDTO;
import byx.project.hrms.pojo.dto.LatestWeekAttendanceQueryDTO;
import byx.project.hrms.pojo.vo.AttendanceListItemVO;
import byx.project.hrms.pojo.vo.LatestWeekAttendanceItemVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 考勤服务接口
 *
 * @author byx
 */
public interface AttendanceService {
    /**
     * 获取考勤列表
     */
    PageInfo<AttendanceListItemVO> getAttendanceList(AttendanceListQueryDTO dto);

    /**
     * 获取最近一周考勤
     */
    List<LatestWeekAttendanceItemVO> getLatestWeekAttendance(LatestWeekAttendanceQueryDTO dto);
}
