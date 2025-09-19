package com.example.main.service;

import java.util.List;

import com.example.main.entity.CustFollowup;

public interface CustFollowupService 
{
	public boolean addCustFollowupDateService(CustFollowup custFollowup);
	public List<CustFollowup> getFollowupForProvidedDate(String date);
}
