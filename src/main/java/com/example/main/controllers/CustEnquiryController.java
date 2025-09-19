package com.example.main.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.main.entity.CustEnquiry;
import com.example.main.entity.CustFollowup;
import com.example.main.entity.Employee;
import com.example.main.model.CustEnquiryModel;
import com.example.main.service.CustEnquiryService;
import com.example.main.service.CustFollowupService;
import com.example.main.service.ProductService;

@Controller
public class CustEnquiryController 
{
	@Autowired
	ProductService productService;
	
	@Autowired
	CustEnquiryService custEnquiryService;
	
	@Autowired
	CustFollowupService custFollowupService;
	
	@GetMapping("/customerEnquiryPage")
	public String customerEnquiryPage(
						Model model,
						@RequestParam(name = "redirect_success" ,required = false) String success,
						@RequestParam(name = "redirect_error" ,required = false) String error
						)
	{
		List<String> list_coursename=productService.getAllCourseNameService();
		model.addAttribute("model_coursename_list", list_coursename);
		
		model.addAttribute("modelCustEnquiryAttr", new CustEnquiryModel());
		
		model.addAttribute("model_success",success);
		model.addAttribute("model_error",error);
		
		return "customer-enquiry";
	}
	
	@PostMapping("/custEnquiryForm")
	public String custEnquiryForm(
									HttpSession session,
									@ModelAttribute("modelCustEnquiryAttr") CustEnquiryModel custEnquiryModel,
									RedirectAttributes redirectAttributes
									)
	{
		LocalDate date=LocalDate.now();
		String date1=date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		LocalTime time=LocalTime.now();
		String time1=time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		
		Employee employee=(Employee) session.getAttribute("session_employee");
		String empemail="";
		if(employee !=null)
		{
			empemail=employee.getEmail();
		}
		
		String phoneno=custEnquiryModel.getPhoneno();
		
		CustEnquiry custEnquiry=custEnquiryModel.getCustEnquiry();
		custEnquiry.setPhoneno(phoneno);
		custEnquiry.setEnquirydate(date1);
		custEnquiry.setEnquirytime(time1);
		custEnquiry.setEmpemail(empemail);
		
		CustFollowup custFollowup=custEnquiryModel.getCustFollowup();
		custFollowup.setPhoneno(phoneno);
		
		boolean status1=custEnquiryService.addCustEnquiryDetailsService(custEnquiry);
		
		boolean status2=custFollowupService.addCustFollowupDateService(custFollowup);
		
		if(status1 && status2)
		{
			redirectAttributes.addAttribute("redirect_success","Customer enquiry details added successfully.");
		}
		else
		{
			redirectAttributes.addAttribute("redirect_error","Customer enquiry details not added due to some error.");
		}
		
		return "redirect:/customerEnquiryPage";
	}
	
	@GetMapping("/customerFollowupPage")
	public String customerFollowupPage(
						Model model,
						@RequestParam(name = "selectedDate", required = false) String selectedDate
						)
	{
		if(selectedDate != null)
		{
			List<CustFollowup> list_followups=custFollowupService.getFollowupForProvidedDate(selectedDate);
			model.addAttribute("model_followups",list_followups);
		}
		else
		{
			LocalDate ld=LocalDate.now();
			String date1=ld.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			
			List<CustFollowup> list_followups=custFollowupService.getFollowupForProvidedDate(date1);
			model.addAttribute("model_followups",list_followups);
		}
		
		return "customer-followup";
	}
	
	@GetMapping("/checkPhoneNumberAvailibility")
	@ResponseBody
	public String checkPhoneNo(@RequestParam("phoneNumber") String phoneno)
	{
		boolean status=custEnquiryService.isPhoneNumberExists(phoneno);
		if(status)
		{
			return "exist";   //exist and not_exist is a string not jsp page so we need to use @ResponseBody
		}
		
		return "not_exist";
	}
	
	@GetMapping("/custEnquiryHistoryPage")
	public String opencustEnquiryHistoryPage(@RequestParam("phno") String phoneno, Model model)
	{
		List<CustEnquiry> list_custenq=custEnquiryService.getCustAllEnquiryHistory(phoneno);
		model.addAttribute("model_custenq", list_custenq);
		
		model.addAttribute("modelCustEnquiryAttr", new CustEnquiryModel());
		
		List<String> list_coursename=productService.getAllCourseNameService();
		model.addAttribute("model_coursename_list", list_coursename);
		
		return "cusenq-history";
	}
}




