package com.ramoys.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramoys.ems.model.Employees;
import com.ramoys.ems.service.EmployeesService;

@RestController
@RequestMapping("/employee/api/v1")
public class EmployeesController {
	@Autowired
	EmployeesService employeesService;
	
	@PostMapping("/add")
	public Employees addEmployee(@RequestBody Employees e) {
		return employeesService.addEmployee(e);
	}
	
	@GetMapping("/fetchAll")
	public List<Employees> fetchAllEmployees(){
		return employeesService.fetchAllEmployees();
	}
	
	@GetMapping("/fetch/{id}")
	public Employees fetchEmployee(@PathVariable long id) {
		return employeesService.fetchEmployee(id);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Employees> updateEmployee(@PathVariable long id, @RequestBody Employees updatedEmployee) {
		return employeesService.updateEmployee(id, updatedEmployee);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
		return employeesService.deleteEmployee(id);
	}
}
