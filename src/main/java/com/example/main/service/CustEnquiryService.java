package com.example.main.service;

import java.util.List;

import com.example.main.entity.CustEnquiry;

public interface CustEnquiryService 
{
	public boolean addCustEnquiryDetailsService(CustEnquiry custEnquiry);
	public boolean isPhoneNumberExists(String phoneNumber);
	public List<CustEnquiry> getCustAllEnquiryHistory(String phoneno);
}
