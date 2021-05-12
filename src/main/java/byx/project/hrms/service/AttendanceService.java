package byx.project.hrms.service;

import byx.project.hrms.pojo.dto.AttendanceListQueryDTO;
import byx.project.hrms.pojo.vo.AttendanceListItemVO;
import com.github.pagehelper.PageInfo;

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
}
