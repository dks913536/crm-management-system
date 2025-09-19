package com.example.main.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.main.entity.Employee;


@Repository //optional annotation
@Transactional
public interface EmpRepository extends JpaRepository<Employee, Integer>
{
	Employee findByEmail(String email);
	void deleteByEmail(String email);
}
