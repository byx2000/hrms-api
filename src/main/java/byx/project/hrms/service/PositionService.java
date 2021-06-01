package byx.project.hrms.service;

import byx.project.hrms.pojo.dto.*;
import byx.project.hrms.pojo.vo.PositionDetailVO;
import byx.project.hrms.pojo.vo.PositionListItemVO;
import byx.project.hrms.pojo.vo.PositionSelectItemVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Position服务接口
 *
 * @author byx
 */
public interface PositionService {
    /**
     * 获取职位列表
     */
    PageInfo<PositionListItemVO> getPositionList(PositionListQueryDTO dto);

    /**
     * 获取所有职位选项（下拉框要用）
     */
    List<PositionSelectItemVO> getAllPositionSelection(PositionSelectQueryDTO dto);

    PositionDetailVO getPositionDetail(PositionDetailQueryDTO dto);

    void update(PositionUpdateDTO dto);

    void insert(PositionInsertDTO dto);

    void delete(PositionDeleteDTO dto);
}
