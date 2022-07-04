package sk.jstasko.department.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.jstasko.department.entity.Department;
import sk.jstasko.department.service.DepartmentService;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/")
    public Department saveDepartment(@RequestBody  Department department) {
        log.info("Inside saveDepartment method of DepartmentController");
        return this.departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long id) {
        log.info("Inside findDepartmentById method of DepartmentController");
        return this.departmentService.findDepartmentById(id);
    }
}
