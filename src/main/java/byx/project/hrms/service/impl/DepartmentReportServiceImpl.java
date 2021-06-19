package byx.project.hrms.service.impl;

import byx.project.hrms.mapper.DepartmentReportMapper;
import byx.project.hrms.pojo.vo.DepartmentEmployeeCountVO;
import byx.project.hrms.pojo.vo.DepartmentPositionCountVO;
import byx.project.hrms.service.DepartmentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门报表服务实现类
 *
 * @author byx
 */
@Service
public class DepartmentReportServiceImpl implements DepartmentReportService {
    @Autowired
    private DepartmentReportMapper departmentReportMapper;

    @Override
    public List<DepartmentEmployeeCountVO> getDepartmentEmployeeCountReport() {
        return departmentReportMapper.getDepartmentEmployeeCount();
    }

    @Override
    public List<DepartmentPositionCountVO> getDepartmentPositionCountReport() {
        return departmentReportMapper.getDepartmentPositionCount();
    }
}
