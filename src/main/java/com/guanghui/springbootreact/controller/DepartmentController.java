package com.guanghui.springbootreact.controller;

import com.guanghui.springbootreact.entity.Department;
import com.guanghui.springbootreact.exception.ResourceNotFoundException;
import com.guanghui.springbootreact.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    public List<Department> getAll() {
        logger.info("get departments in department controller");
        return departmentService.getAll();
    }

    @GetMapping("{id}")
    public Department getById(@PathVariable Long id) throws ResourceNotFoundException {
        return departmentService.getById(id);
    }

    @PostMapping()
    // @Valid will validate Department Entity's annotation. e.g. name is not blank.
    public Department save(@Valid @RequestBody Department department) {

        logger.info("Save department in department controller");
        return departmentService.save(department);
    }

    @PutMapping("{id}")
    public Department update(@RequestBody Department department, @PathVariable("id") Long departmentId) throws ResourceNotFoundException {
        return departmentService.update(departmentId, department);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id) {
        departmentService.delete(id);
    }

    @GetMapping("name/{name}")
    public Department getByName(@PathVariable String name) {
        return departmentService.getByName(name);
    }

}
