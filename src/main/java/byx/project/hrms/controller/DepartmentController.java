package byx.project.hrms.controller;

import byx.project.hrms.common.Result;
import byx.project.hrms.pojo.vo.DepartmentSelectItemVO;
import byx.project.hrms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Department控制器
 *
 * @author byx
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取所有部门选项（下拉框要用）
     */
    @PostMapping("/selection")
    public Result<List<DepartmentSelectItemVO>> selection() {
        return Result.success(departmentService.getAllDepartmentSelection());
    }
}
