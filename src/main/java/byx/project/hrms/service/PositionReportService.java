package byx.project.hrms.service;

import byx.project.hrms.pojo.dto.PositionEmployeeCountQueryDTO;
import byx.project.hrms.pojo.vo.PositionEmployeeCountVO;

import java.util.List;

/**
 * 职位报表服务接口
 *
 * @author byx
 */
public interface PositionReportService {
    /**
     * 获取指定部门的职位员工数量报表
     */
    List<PositionEmployeeCountVO> getPositionEmployeeCountReport(PositionEmployeeCountQueryDTO dto);
}
