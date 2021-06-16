package byx.project.hrms.service.impl;

import byx.project.hrms.mapper.EmployeeReportMapper;
import byx.project.hrms.pojo.vo.EmployeeAgeReportVO;
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
    public EmployeeAgeReportVO getEmployeeAgeReport() {
        List<String> labels = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        labels.add("20-30岁");
        values.add(employeeReportMapper.countByAge(20, 30));
        labels.add("31-40岁");
        values.add(employeeReportMapper.countByAge(31, 40));
        labels.add("41-50岁");
        values.add(employeeReportMapper.countByAge(41, 50));
        labels.add("大于50岁");
        values.add(employeeReportMapper.countByAge(51, null));

        EmployeeAgeReportVO vo = new EmployeeAgeReportVO();
        vo.setLabels(labels);
        vo.setValues(values);

        return vo;
    }
}
