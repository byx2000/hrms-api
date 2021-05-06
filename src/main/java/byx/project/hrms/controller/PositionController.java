package byx.project.hrms.controller;

import byx.project.hrms.common.Result;
import byx.project.hrms.pojo.dto.PositionSelectQueryDTO;
import byx.project.hrms.pojo.vo.PositionSelectItemVO;
import byx.project.hrms.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Position控制器
 *
 * @author byx
 */
@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    /**
     * 根据部门获取所有职位选项（下拉框要用）
     */
    @PostMapping("/selection")
    public Result<List<PositionSelectItemVO>> selection(@RequestBody @Validated PositionSelectQueryDTO dto) {
        return Result.success(positionService.getAllPositionSelection(dto));
    }
}
