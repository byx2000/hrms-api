package byx.project.hrms.service.impl;

import byx.project.hrms.mapper.AttendanceReportMapper;
import byx.project.hrms.pojo.vo.AttendanceReportVO;
import byx.project.hrms.service.AttendanceReportService;
import byx.project.hrms.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 考勤报表服务实现类
 *
 * @author byx
 */
@Service
public class AttendanceReportServiceImpl implements AttendanceReportService {
    @Autowired
    private AttendanceReportMapper attendanceReportMapper;

    @Override
    public List<AttendanceReportVO> getLatestMonthAttendanceReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.APRIL, 12);
        List<AttendanceReportVO> vos = new ArrayList<>();
        for (int i = 0; i < 31; ++i) {
            String date = DateUtils.toString(calendar.getTime());
            AttendanceReportVO vo = new AttendanceReportVO();
            vo.setDate(date);
            vo.setNormalCount(attendanceReportMapper.getNormalCount(date));
            vo.setArriveLateCount(attendanceReportMapper.getArriveLateCount(date));
            vo.setLeaveEarlyCount(attendanceReportMapper.getLeaveEarlyCount(date));
            vos.add(vo);
            calendar.add(Calendar.DATE, 1);
        }
        return vos;
    }
}
