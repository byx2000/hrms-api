package byx.project.hrms.service.impl;

import byx.project.hrms.mapper.PositionReportMapper;
import byx.project.hrms.pojo.dto.PositionEmployeeCountQueryDTO;
import byx.project.hrms.pojo.vo.PositionEmployeeCountVO;
import byx.project.hrms.service.PositionReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 职位报表服务实现类
 *
 * @author byx
 */
@Service
public class PositionReportServiceImpl implements PositionReportService {
    @Autowired
    private PositionReportMapper positionReportMapper;

    @Override
    public List<PositionEmployeeCountVO> getPositionEmployeeCountReport(PositionEmployeeCountQueryDTO dto) {
        return positionReportMapper.getPositionEmployeeCount(dto);
    }
}
