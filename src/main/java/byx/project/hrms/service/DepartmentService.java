package byx.project.hrms.service;

import byx.project.hrms.pojo.dto.*;
import byx.project.hrms.pojo.vo.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Department服务接口
 *
 * @author byx ztc
 */
public interface DepartmentService {
    /**
     * 获取所有部门选项（下拉框要用）
     */
    List<DepartmentSelectItemVO> getAllDepartmentSelection();

    /**
     * 获取部门列表
     */
    PageInfo<DepartmentListItemVO> getDepartmentList(DepartmentListQueryDTO dto);

    /**
     * 获取部门详情
     */
    DepartmentDetailVO getDepartmentDetail(DepartmentDetailQueryDTO dto);

    /**
     * 更新部门信息
     */
    void update(DepartmentUpdateDTO dto);

    /**
     * 删除部门
     */
    void delete(DepartmentDeleteDTO dto);

    /**
     * 插入部门
     */
    void insert(DepartmentInsertDTO dto);
}
