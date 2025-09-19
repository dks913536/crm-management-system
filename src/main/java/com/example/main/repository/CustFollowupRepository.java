package com.example.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.entity.CustFollowup;

import java.util.List;


public interface CustFollowupRepository extends JpaRepository<CustFollowup, Integer>
{
	CustFollowup findByPhoneno(String phoneno);
	List<CustFollowup> findByFollowupdate(String followupdate);
}
