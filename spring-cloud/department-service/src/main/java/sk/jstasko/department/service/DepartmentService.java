package sk.jstasko.department.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.jstasko.department.entity.Department;
import sk.jstasko.department.repository.DepartmentRepository;

@Service
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(
            DepartmentRepository departmentRepository
    ) {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(Department department) {
        log.info("Inside of saveDepartment, method of DepartmentService");
        return this.departmentRepository.save(department);
    }

    public Department findDepartmentById(Long id) {
        log.info("Inside of findDepartmentById, method of DepartmentService");
        return this.departmentRepository.findByDepartmentId(id);
    }
}
