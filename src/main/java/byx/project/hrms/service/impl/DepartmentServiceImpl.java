package byx.project.hrms.service.impl;

import byx.project.hrms.mapper.DepartmentMapper;
import byx.project.hrms.pojo.dto.*;
import byx.project.hrms.pojo.vo.DepartmentDetailVO;
import byx.project.hrms.pojo.vo.DepartmentListItemVO;
import byx.project.hrms.pojo.vo.DepartmentSelectItemVO;
import byx.project.hrms.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Department服务实现类
 *
 * @author byx ztc
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentSelectItemVO> getAllDepartmentSelection() {
        return departmentMapper.listAll();
    }

    @Override
    public PageInfo<DepartmentListItemVO> getDepartmentList(DepartmentListQueryDTO dto) {
        PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
        //return new PageInfo<>(departmentMapper.list(dto));
        List<DepartmentListItemVO> listItemVOS=departmentMapper.list(dto);
        return new PageInfo<>(listItemVOS);
    }

    @Override
    public DepartmentDetailVO getDepartmentDetail(DepartmentDetailQueryDTO dto) {
        DepartmentDetailVO vo=departmentMapper.get(dto);
        return vo;
    }

    @Override
    public void update(DepartmentUpdateDTO dto) {
        departmentMapper.update(dto);
    }

    @Override
    public void delete(DepartmentDeleteDTO dto) {
        departmentMapper.delete(dto);
    }

    @Override
    public void insert(DepartmentInsertDTO dto) {
        departmentMapper.insert( dto);
    }
}
