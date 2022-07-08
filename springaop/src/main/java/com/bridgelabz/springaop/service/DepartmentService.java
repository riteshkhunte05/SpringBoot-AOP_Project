package com.bridgelabz.springaop.service;

import com.bridgelabz.springaop.annotation.CustomAnnotation;
import com.bridgelabz.springaop.model.Department;
import com.bridgelabz.springaop.repositorty.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department ){
        return departmentRepository.save(department);
    }

    @CustomAnnotation
    public Department findById(Integer id ){
        return departmentRepository.findById(id).orElse(null);
    }
}