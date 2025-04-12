package com.ito.crud_rest.dao;

import com.ito.crud_rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // No additional methods are needed here as JpaRepository provides all the necessary CRUD operations

}
