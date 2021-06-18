package byx.project.hrms.controller;

import byx.project.hrms.common.Result;
import byx.project.hrms.pojo.vo.EmployeeAgeReportVO;
import byx.project.hrms.pojo.vo.EmployeeTypeReportVO;
import byx.project.hrms.service.EmployeeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 员工报表控制器
 *
 * @author byx
 */
@RestController
@RequestMapping("/report/employee")
public class EmployeeReportController {
    @Autowired
    private EmployeeReportService employeeReportService;

    /**
     * 获取年龄报表
     */
    @PostMapping("/age")
    public Result<List<EmployeeAgeReportVO>> age() {
        return Result.success(employeeReportService.getEmployeeAgeReport());
    }

    /**
     * 获取类型报表
     */
    @PostMapping("/type")
    public Result<EmployeeTypeReportVO> type() {
        return Result.success(employeeReportService.getEmployeeTypeReport());
    }
}
