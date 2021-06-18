package byx.project.hrms.service.impl;

import byx.project.hrms.mapper.EmployeeReportMapper;
import byx.project.hrms.pojo.vo.EmployeeAgeReportVO;
import byx.project.hrms.pojo.vo.EmployeeTypeReportVO;
import byx.project.hrms.service.EmployeeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工报表服务实现类
 *
 * @author byx
 */
@Service
public class EmployeeReportServiceImpl implements EmployeeReportService {
    @Autowired
    private EmployeeReportMapper employeeReportMapper;

    @Override
    public List<EmployeeAgeReportVO> getEmployeeAgeReport() {

        List<EmployeeAgeReportVO> vos = new ArrayList<>();
        vos.add(buildEmployeeAgeReportVO("小于30岁", null, 30));
        vos.add(buildEmployeeAgeReportVO("31-40岁", 31, 40));
        vos.add(buildEmployeeAgeReportVO("41-50岁", 41, 50));
        vos.add(buildEmployeeAgeReportVO("大于50岁", 51, null));
        return vos;
    }

    private EmployeeAgeReportVO buildEmployeeAgeReportVO(String label, Integer minAge, Integer maxAge) {
        EmployeeAgeReportVO vo = new EmployeeAgeReportVO();
        vo.setLabel(label);
        vo.setMaleCount(employeeReportMapper.countByAgeAndGender(minAge, maxAge, 0));
        vo.setFemaleCount(employeeReportMapper.countByAgeAndGender(minAge, maxAge, 1));
        return vo;
    }

    @Override
    public EmployeeTypeReportVO getEmployeeTypeReport() {
        EmployeeTypeReportVO vo = new EmployeeTypeReportVO();
        vo.setInternCount(employeeReportMapper.countByType(0));
        vo.setFullTimeCount(employeeReportMapper.countByType(1));
        return vo;
    }
}
