package byx.project.hrms.controller;

import byx.project.hrms.common.Result;
import byx.project.hrms.pojo.dto.*;
import byx.project.hrms.pojo.vo.*;
import byx.project.hrms.service.DepartmentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Department控制器
 *
 * @author byx ztc
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

    /**
     * 查询部门列表
     */
    @PostMapping("/list")
    public Result<PageInfo<DepartmentListItemVO>> list(@RequestBody @Validated DepartmentListQueryDTO dto) {
        return Result.success(departmentService.getDepartmentList(dto));
    }

    /**
     * 获取部门详情
     */
    @PostMapping("/detail")
    public Result<DepartmentDetailVO> detail(@RequestBody @Validated DepartmentDetailQueryDTO dto) {
        return Result.success(departmentService.getDepartmentDetail(dto));
    }

    /**
     * 更新部门信息
     */
    @PostMapping("/update")
    public Result<?> update(@RequestBody @Validated DepartmentUpdateDTO dto) {
        departmentService.update(dto);
        return Result.success();
    }

    /**
     * 删除部门
     */
    @PostMapping("/delete")
    public Result<?> delete(@RequestBody @Validated DepartmentDeleteDTO dto) {
        departmentService.delete(dto);
        return Result.success();
    }

    /**
     * 插入部门
     */
    @PostMapping("/insert")
    public Result<?> insert(@RequestBody @Validated DepartmentInsertDTO dto) {
        departmentService.insert(dto);
        return Result.success();
    }
}
