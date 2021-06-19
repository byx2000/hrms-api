package byx.project.hrms.service;

import byx.project.hrms.pojo.vo.DepartmentEmployeeCountVO;
import byx.project.hrms.pojo.vo.DepartmentPositionCountVO;

import java.util.List;

/**
 * 部门报表服务接口
 *
 * @author byx
 */
public interface DepartmentReportService {
    /**
     * 获取部门员工人数报表
     */
    List<DepartmentEmployeeCountVO> getDepartmentEmployeeCountReport();

    /**
     * 获取部门职位数报表
     */
    List<DepartmentPositionCountVO> getDepartmentPositionCountReport();
}
