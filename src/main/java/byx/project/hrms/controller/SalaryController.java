package byx.project.hrms.controller;

import byx.project.hrms.common.Result;
import byx.project.hrms.pojo.dto.SalaryQueryDTO;
import byx.project.hrms.pojo.vo.SalaryItemVO;
import byx.project.hrms.service.SalaryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Salary控制器
 *
 * @author byx
 */
@RestController
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    /**
     * 查询薪资列表
     */
    @PostMapping("/list")
    public Result<PageInfo<SalaryItemVO>> list(@RequestBody @Validated SalaryQueryDTO dto) {
        return Result.success(salaryService.getSalaryList(dto));
    }
}
