package com.ramoys.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramoys.ems.exception.ResourceNotFoundException;
import com.ramoys.ems.model.Employees;
import com.ramoys.ems.repository.EmployeesRepository;

@Service
public class EmployeesService {
	@Autowired
	EmployeesRepository employeesRepository;
	
	public Employees addEmployee(Employees e) {
		return employeesRepository.save(e);
	}
	
	public List<Employees> addMultipleEmployees(List<Employees> e){
		return employeesRepository.saveAll(e);
	}
	public List<Employees> fetchAllEmployees(){
		return employeesRepository.findAll();
	}
	
	public Employees fetchEmployee(long id) {
		return employeesRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id Not Found"));
	}
	
	public ResponseEntity<Employees> updateEmployee(long id, Employees updatedEmployee) {
		Employees existingEmployee = employeesRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id Not Found"));
		
		// Manual update of each field
        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setPhone(updatedEmployee.getPhone());
        existingEmployee.setEmergencyContact(updatedEmployee.getEmergencyContact());
        existingEmployee.setGender(updatedEmployee.getGender());
        existingEmployee.setDateOfBirth(updatedEmployee.getDateOfBirth());
        existingEmployee.setDesignation(updatedEmployee.getDesignation());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setAddress(updatedEmployee.getAddress());
        existingEmployee.setCity(updatedEmployee.getCity());
        existingEmployee.setState(updatedEmployee.getState());
        existingEmployee.setZipCode(updatedEmployee.getZipCode());
        existingEmployee.setCountry(updatedEmployee.getCountry());
        existingEmployee.setJoiningDate(updatedEmployee.getJoiningDate());
        existingEmployee.setEmploymentType(updatedEmployee.getEmploymentType());
        existingEmployee.setStatus(updatedEmployee.getStatus());
        existingEmployee.setAadhaarNumber(updatedEmployee.getAadhaarNumber());
        
        employeesRepository.save(existingEmployee);
        
        return ResponseEntity.ok(existingEmployee);
	}
	
	public ResponseEntity<HttpStatus> deleteEmployee(long id){
		Employees e = employeesRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id Not Found"));
		employeesRepository.delete(e);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
