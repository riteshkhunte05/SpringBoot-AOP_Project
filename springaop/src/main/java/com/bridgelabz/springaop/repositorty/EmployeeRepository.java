package com.bridgelabz.springaop.repositorty;

import com.bridgelabz.springaop.model.Department;
import com.bridgelabz.springaop.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}