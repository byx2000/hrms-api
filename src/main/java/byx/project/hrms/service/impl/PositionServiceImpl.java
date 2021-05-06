package byx.project.hrms.service.impl;

import byx.project.hrms.mapper.PositionMapper;
import byx.project.hrms.pojo.dto.PositionSelectQueryDTO;
import byx.project.hrms.pojo.vo.PositionSelectItemVO;
import byx.project.hrms.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Position服务实现类
 *
 * @author byx
 */
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;

    @Override
    public List<PositionSelectItemVO> getAllPositionSelection(PositionSelectQueryDTO dto) {
        return positionMapper.list(dto);
    }
}
