package byx.project.hrms.service;

import byx.project.hrms.pojo.vo.DepartmentSelectItemVO;

import java.util.List;

/**
 * Department服务接口
 *
 * @author byx
 */
public interface DepartmentService {
    /**
     * 获取所有部门选项（下拉框要用）
     */
    List<DepartmentSelectItemVO> getAllDepartmentSelection();
}
