package com.ramoys.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ramoys.ems.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);

}
