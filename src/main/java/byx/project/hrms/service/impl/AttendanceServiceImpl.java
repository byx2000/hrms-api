package byx.project.hrms.service.impl;

import byx.project.hrms.mapper.AttendanceMapper;
import byx.project.hrms.pojo.dto.AttendanceListQueryDTO;
import byx.project.hrms.pojo.vo.AttendanceListItemVO;
import byx.project.hrms.service.AttendanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 考勤服务实现类
 *
 * @author byx
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public PageInfo<AttendanceListItemVO> getAttendanceList(AttendanceListQueryDTO dto) {
        PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
        return new PageInfo<>(attendanceMapper.list(dto));
    }
}
