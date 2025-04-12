package com.ito.crud_rest.dao;

import com.ito.crud_rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // No additional methods are needed here as JpaRepository provides all the necessary CRUD operations

}
