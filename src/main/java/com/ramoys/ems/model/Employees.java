package com.ramoys.ems.model;

import java.time.LocalDate;

import com.ramoys.ems.model.enums.EmployeeGender;
import com.ramoys.ems.model.enums.EmployeeStatus;
import com.ramoys.ems.model.enums.EmployementType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employees {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String emergencyContact;
    
    @Enumerated(EnumType.STRING)
    private EmployeeGender gender;
    
    private LocalDate dateOfBirth;
    private String designation;  // e.g., "Software Engineer"
    private String department;   // e.g., "IT", "HR", "Finance"
    private Double salary;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private LocalDate joiningDate;
    
    @Enumerated(EnumType.STRING)
    private EmployementType employmentType; // e.g., "Full-Time", "Part-Time", "Intern"
    
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status; // e.g., "Active", "Resigned", "On Leave", "Terminated"
    
    private String aadhaarNumber;	//e.g India-specific
	
}
