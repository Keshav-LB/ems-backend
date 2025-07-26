package com.ramoys.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ramoys.ems.model.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer>{

}
