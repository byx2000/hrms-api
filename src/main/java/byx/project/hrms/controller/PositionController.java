package byx.project.hrms.controller;

import byx.project.hrms.common.Result;
import byx.project.hrms.pojo.dto.*;
import byx.project.hrms.pojo.vo.PositionDetailVO;
import byx.project.hrms.pojo.vo.PositionListItemVO;
import byx.project.hrms.pojo.vo.PositionSelectItemVO;
import byx.project.hrms.service.PositionService;
import com.github.pagehelper.PageInfo;
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
     * 查询职位列表
     */
    @PostMapping("/list")
    public Result<PageInfo<PositionListItemVO>> list(@RequestBody @Validated PositionListQueryDTO dto) {
        return Result.success(positionService.getPositionList(dto));
    }

    /**
     * 根据部门获取所有职位选项（下拉框要用）
     */
    @PostMapping("/selection")
    public Result<List<PositionSelectItemVO>> selection(@RequestBody @Validated PositionSelectQueryDTO dto) {
        return Result.success(positionService.getAllPositionSelection(dto));
    }

    /**
     * 获取职位详情
     */
    @PostMapping("/detail")
    public Result<PositionDetailVO> detail(@RequestBody @Validated PositionDetailQueryDTO dto) {
        return Result.success(positionService.getPositionDetail(dto));
    }

    /**
     * 更新职位信息
     */
    @PostMapping("/update")
    public Result<?> update(@RequestBody @Validated PositionUpdateDTO dto) {
        positionService.update(dto);
        return Result.success();
    }

    /**
     * 删除职位
     */
    @PostMapping("/delete")
    public Result<?> delete(@RequestBody @Validated PositionDeleteDTO dto) {
        positionService.delete(dto);
        return Result.success();
    }

    /**
     * 插入职位
     */
    @PostMapping("/insert")
    public Result<?> insert(@RequestBody @Validated PositionInsertDTO dto) {
        positionService.insert(dto);
        return Result.success();
    }

}
