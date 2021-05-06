package byx.project.hrms.service.impl;

import byx.project.hrms.mapper.DepartmentMapper;
import byx.project.hrms.pojo.vo.DepartmentSelectItemVO;
import byx.project.hrms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Department服务实现类
 *
 * @author byx
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentSelectItemVO> getAllDepartmentSelection() {
        return departmentMapper.listAll();
    }
}
