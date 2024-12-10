package com.example.Crud.dao;

import com.example.Crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    //method to sort ASC By FirstName
    public List<Employee> findAllByOrderByFirstNameAsc();

}
