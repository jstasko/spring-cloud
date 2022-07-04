package sk.jstasko.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.jstasko.department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentId(Long id);
}
