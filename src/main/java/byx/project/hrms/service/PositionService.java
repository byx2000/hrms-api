package byx.project.hrms.service;

import byx.project.hrms.pojo.dto.PositionSelectQueryDTO;
import byx.project.hrms.pojo.vo.PositionSelectItemVO;

import java.util.List;

/**
 * Position服务接口
 *
 * @author byx
 */
public interface PositionService {
    /**
     * 获取所有职位选项（下拉框要用）
     */
    List<PositionSelectItemVO> getAllPositionSelection(PositionSelectQueryDTO dto);
}
