package com.guanghui.springbootreact.service;

import com.guanghui.springbootreact.entity.Employee;
import com.guanghui.springbootreact.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee employeeEntity = new Employee();
        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepository.save(employeeEntity);

        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employeeEntities = employeeRepository.findAll();

        return employeeEntities.stream().map(emp -> new Employee(
                emp.getId(),
                emp.getFirstName(),
                emp.getLastName(),
                emp.getEmail()
        )).collect(Collectors.toList());
    }

    @Override
    public boolean deleteEmployee(Long id) {
        Optional<Employee> employeeEntity = employeeRepository.findById(id);

        if (employeeEntity.isPresent()) {
            employeeRepository.delete(employeeEntity.get());
        }
        return false;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeEntity = employeeRepository.findById(id);

        if (employeeEntity.isPresent()) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeEntity.get(), employee);
            return employee;
        }
        return null;
    }


    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> employeeEntity = employeeRepository.findById(id);

        if (employeeEntity.isPresent()) {
            Employee e = employeeEntity.get();
            e.setEmail(employee.getEmail());
            e.setFirstName(employee.getFirstName());
            e.setLastName(employee.getLastName());

            return employeeRepository.save(e);
        }

        return null;
    }
}