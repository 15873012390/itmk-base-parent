package com.itmk.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmk.system.entity.Department;
import com.itmk.system.mapper.DepartmentMapper;
import com.itmk.system.service.DepartmnetService;
import org.springframework.stereotype.Service;

@Service
public class DepartmnetServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmnetService {
}
