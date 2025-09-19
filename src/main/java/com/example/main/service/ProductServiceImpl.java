package com.example.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.entity.Product;
import com.example.main.entity.SaleCourse;
import com.example.main.repository.ProductRepository;
import com.example.main.repository.SaleCourseRepository;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SaleCourseRepository saleCourseRepository;

	@Override
	public boolean addProductService(Product product) 
	{ 
		boolean status=false;
		
		try 
		{
			productRepository.save(product);
			status=true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Product> getAllProductsListService() 
	{
		return productRepository.findAll();
	}

	@Override
	public Product getProductDetailsService(String coursename) 
	{
		return productRepository.findByCoursename(coursename);
	}

	@Override
	public List<String> getAllCourseNameService() 
	{
		return productRepository.findCourseName();
	}

	@Override
	public Product getSelectedCourseDeatilsService(String coursename) 
	{
		return productRepository.findByCoursename(coursename);
	}

	@Override
	public boolean addSaleCourseDetailsService(SaleCourse saleCourse) 
	{
		boolean status=false;
		
		try 
		{
			saleCourseRepository.save(saleCourse);
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
	public List<Object[]> getPurchasedCourseCountService() 
	{
		return saleCourseRepository.countByPurchasedDate();
	}

}
