package com.guanghui.springbootreact.repository;

import com.guanghui.springbootreact.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String name);

    Department findByNameIgnoreCase(String name);
}
