package byx.project.hrms.service.impl;

import byx.project.hrms.mapper.EmployeeMapper;
import byx.project.hrms.mapper.PositionMapper;
import byx.project.hrms.pojo.dto.*;
import byx.project.hrms.pojo.vo.PositionDetailVO;
import byx.project.hrms.pojo.vo.PositionListItemVO;
import byx.project.hrms.pojo.vo.PositionSelectItemVO;
import byx.project.hrms.service.PositionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageInfo<PositionListItemVO> getPositionList(PositionListQueryDTO dto) {
        PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
        return new PageInfo<>(positionMapper.list(dto));
    }


    @Override
    public List<PositionSelectItemVO> getAllPositionSelection(PositionSelectQueryDTO dto) {
        return positionMapper.selectPositions(dto);
    }

    @Override
    public PositionDetailVO getPositionDetail(PositionDetailQueryDTO dto) {
        var detailVO = positionMapper.getDetail(dto);
        List<PositionDetailVO.EmployeeVO> employees = employeeMapper.getByPosNo(dto);
        return new PositionDetailVO(detailVO, employees);
    }

    @Override
    public void update(PositionUpdateDTO dto) {
        positionMapper.update(dto);
    }

    @Override
    public void insert(PositionInsertDTO dto) {
        positionMapper.insert(dto);
    }

    @Override
    public void delete(PositionDeleteDTO dto) {
        positionMapper.delete(dto);
    }
}
