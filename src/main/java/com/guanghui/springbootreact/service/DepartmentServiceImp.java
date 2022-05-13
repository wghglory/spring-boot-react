package com.guanghui.springbootreact.service;

import com.guanghui.springbootreact.entity.Department;
import com.guanghui.springbootreact.exception.ResourceNotFoundException;
import com.guanghui.springbootreact.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(Long id) throws ResourceNotFoundException {
        Optional<Department> departDb = departmentRepository.findById(id);

        if (departDb.isEmpty()) {
            throw new ResourceNotFoundException(id);
        }

        return departDb.get();

//        return departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department update(Long departmentId, Department department) throws ResourceNotFoundException {
        Optional<Department> departDb = departmentRepository.findById(departmentId);

        if (departDb.isEmpty()) {
            throw new ResourceNotFoundException(departmentId);
        } else {
            Department depart = departDb.get();

            String name = department.getName();
            if (Objects.nonNull(name) && !name.equals("")) {
                depart.setName(name);
            }
            String address = department.getAddress();
            if (Objects.nonNull(address) && !address.equals("")) {
                depart.setAddress(address);
            }
            String code = department.getCode();
            if (Objects.nonNull(code) && !code.equals("")) {
                depart.setCode(code);
            }
            return departmentRepository.save(depart);
        }

    }

    @Override
    public Department getByName(String name) {
        return departmentRepository.findByNameIgnoreCase(name);
//        return departmentRepository.findByName(name);
//        https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    }
}
