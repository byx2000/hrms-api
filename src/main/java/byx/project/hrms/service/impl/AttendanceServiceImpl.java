package byx.project.hrms.service.impl;

import byx.project.hrms.mapper.AttendanceMapper;
import byx.project.hrms.pojo.dto.AttendanceListQueryDTO;
import byx.project.hrms.pojo.dto.AttendanceTimeItemDTO;
import byx.project.hrms.pojo.dto.LatestWeekAttendanceQueryDTO;
import byx.project.hrms.pojo.vo.AttendanceListItemVO;
import byx.project.hrms.pojo.vo.LatestWeekAttendanceItemVO;
import byx.project.hrms.service.AttendanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<LatestWeekAttendanceItemVO> getLatestWeekAttendance(LatestWeekAttendanceQueryDTO dto) {
        List<AttendanceTimeItemDTO> arriveTimes = attendanceMapper.listTime(dto.getEmpId(), "2021-05-06", "2021-05-12", 0);
        List<AttendanceTimeItemDTO> leaveTimes = attendanceMapper.listTime(dto.getEmpId(), "2021-05-06", "2021-05-12", 1);
        List<LatestWeekAttendanceItemVO> vos = new ArrayList<>();
        for (int i = 0; i < arriveTimes.size(); ++i) {
            LatestWeekAttendanceItemVO vo = new LatestWeekAttendanceItemVO();
            vo.setDate(arriveTimes.get(i).getDate());
            vo.setArriveTime(arriveTimes.get(i).getTime());
            vo.setLeaveTime(leaveTimes.get(i).getTime());
            vos.add(vo);
        }
        return vos;
    }
}
