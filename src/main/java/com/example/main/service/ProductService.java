package com.example.main.service;

import java.util.List;

import com.example.main.entity.Product;
import com.example.main.entity.SaleCourse;


public interface ProductService 
{
	public boolean addProductService(Product product);
	public List<Product> getAllProductsListService();
	public Product getProductDetailsService(String coursename);
	public List<String> getAllCourseNameService();
	public Product getSelectedCourseDeatilsService(String coursename);
	public boolean addSaleCourseDetailsService(SaleCourse saleCourse);
	public List<Object[]> getPurchasedCourseCountService();
	
}
