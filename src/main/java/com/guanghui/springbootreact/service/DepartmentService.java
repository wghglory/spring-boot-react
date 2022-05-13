package com.guanghui.springbootreact.service;


import com.guanghui.springbootreact.entity.Department;
import com.guanghui.springbootreact.exception.ResourceNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department save(Department department);

    List<Department> getAll();

    Department getById(Long id) throws ResourceNotFoundException;

    void delete(Long id);

    Department update(Long departmentId, Department department) throws ResourceNotFoundException;

    Department getByName(String name);
}
