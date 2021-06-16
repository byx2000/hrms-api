package byx.project.hrms.service;

import byx.project.hrms.pojo.vo.EmployeeAgeReportVO;
import byx.project.hrms.pojo.vo.EmployeeGenderReportVO;
import byx.project.hrms.pojo.vo.EmployeeTypeReportVO;

/**
 * 员工报表服务接口
 *
 * @author byx
 */
public interface EmployeeReportService {
    /**
     * 获取员工年龄报表
     */
    EmployeeAgeReportVO getEmployeeAgeReport();

    /**
     * 获取员工性别报表
     */
    EmployeeGenderReportVO getEmployeeGenderReport();

    /**
     * 获取员工类型报表
     */
    EmployeeTypeReportVO getEmployeeTypeReport();
}
