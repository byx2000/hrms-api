package byx.project.hrms.controller;

import byx.project.hrms.common.Result;
import byx.project.hrms.pojo.vo.DepartmentEmployeeCountVO;
import byx.project.hrms.service.DepartmentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门报表控制器
 *
 * @author byx
 */
@RestController
@RequestMapping("/report/department")
public class DepartmentReportController {
    @Autowired
    private DepartmentReportService departmentReportService;

    /**
     * 获取部门员工人数报表
     */
    @PostMapping("/employee-count")
    public Result<List<DepartmentEmployeeCountVO>> employeeCount() {
        return Result.success(departmentReportService.getDepartmentEmployeeCountReport());
    }
}
