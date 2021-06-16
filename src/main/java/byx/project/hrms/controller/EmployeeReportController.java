package byx.project.hrms.controller;

import byx.project.hrms.common.Result;
import byx.project.hrms.pojo.vo.EmployeeAgeReportVO;
import byx.project.hrms.pojo.vo.EmployeeGenderReportVO;
import byx.project.hrms.pojo.vo.EmployeeTypeReportVO;
import byx.project.hrms.service.EmployeeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result<EmployeeAgeReportVO> age() {
        return Result.success(employeeReportService.getEmployeeAgeReport());
    }

    /**
     * 获取性别报表
     */
    @PostMapping("/gender")
    public Result<EmployeeGenderReportVO> gender() {
        return Result.success(employeeReportService.getEmployeeGenderReport());
    }

    /**
     * 获取类型报表
     */
    @PostMapping("/type")
    public Result<EmployeeTypeReportVO> type() {
        return Result.success(employeeReportService.getEmployeeTypeReport());
    }
}
