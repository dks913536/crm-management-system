package com.example.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.entity.CustEnquiry;
import com.example.main.repository.CustEnquiryRepository;

@Service
public class CustEnquiryServiceImpl implements CustEnquiryService
{
	@Autowired
	CustEnquiryRepository custEnquiryRepository;

	@Override
	public boolean addCustEnquiryDetailsService(CustEnquiry custEnquiry) 
	{
		boolean status=false;
		
		try 
		{
			custEnquiryRepository.save(custEnquiry);
			status=true;
		} 
		catch (Exception e) 
		{
			status=false;
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public boolean isPhoneNumberExists(String phoneNumber) 
	{
		return custEnquiryRepository.existsByPhoneno(phoneNumber);
	}

	@Override
	public List<CustEnquiry> getCustAllEnquiryHistory(String phoneno) 
	{
		return custEnquiryRepository.findAllByPhoneno(phoneno);
	}
	
}
