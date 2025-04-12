package com.ito.crud_rest.dao;

import com.ito.crud_rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findALl();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
