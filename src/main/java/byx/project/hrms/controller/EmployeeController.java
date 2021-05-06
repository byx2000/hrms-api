package byx.project.hrms.controller;

import byx.project.hrms.common.Result;
import byx.project.hrms.pojo.dto.*;
import byx.project.hrms.pojo.vo.EmployeeDetailVO;
import byx.project.hrms.pojo.vo.EmployeeListItemVO;
import byx.project.hrms.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Employee控制器
 *
 * @author byx
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询员工列表
     */
    @PostMapping("/list")
    public Result<PageInfo<EmployeeListItemVO>> list(@RequestBody @Validated EmployeeListQueryDTO dto) {
        return Result.success(employeeService.getEmployeeList(dto));
    }

    /**
     * 获取员工详情
     */
    @PostMapping("/detail")
    public Result<EmployeeDetailVO> detail(@RequestBody @Validated EmployeeDetailQueryDTO dto) {
        return Result.success(employeeService.getEmployeeDetail(dto));
    }

    /**
     * 更新员工信息
     */
    @PostMapping("/update")
    public Result<?> update(@RequestBody @Validated EmployeeUpdateDTO dto) {
        employeeService.update(dto);
        return Result.success();
    }

    /**
     * 删除员工
     */
    @PostMapping("/delete")
    public Result<?> delete(@RequestBody @Validated EmployeeDeleteDTO dto) {
        employeeService.delete(dto);
        return Result.success();
    }

    /**
     * 插入员工
     */
    @PostMapping("/insert")
    public Result<?> insert(@RequestBody @Validated EmployeeInsertDTO dto) {
        employeeService.insert(dto);
        return Result.success();
    }
}
