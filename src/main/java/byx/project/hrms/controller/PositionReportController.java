package byx.project.hrms.controller;

import byx.project.hrms.common.Result;
import byx.project.hrms.pojo.dto.PositionEmployeeCountQueryDTO;
import byx.project.hrms.pojo.vo.PositionEmployeeCountVO;
import byx.project.hrms.service.PositionReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 职位报表控制器
 *
 * @author byx
 */
@RestController
@RequestMapping("/report/position")
public class PositionReportController {
    @Autowired
    private PositionReportService positionReportService;

    /**
     * 获取指定部门的职位员工数量报表
     */
    @PostMapping("/employee-count")
    public Result<List<PositionEmployeeCountVO>> employeeCount(@RequestBody @Validated PositionEmployeeCountQueryDTO dto) {
        return Result.success(positionReportService.getPositionEmployeeCountReport(dto));
    }
}
