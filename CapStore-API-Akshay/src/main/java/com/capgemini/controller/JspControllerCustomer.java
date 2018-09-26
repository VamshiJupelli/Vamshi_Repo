package com.capgemini.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.capgemini.dto.Admin;
import com.capgemini.dto.Carts;
import com.capgemini.dto.Customers;
import com.capgemini.dto.Merchants;
import com.capgemini.dto.ProductCategory;
import com.capgemini.dto.ProductListDummy;
import com.capgemini.dto.Products;


@Controller
public class JspControllerCustomer {

	@RequestMapping("/customerlogin")
	public String showConsumerLoginPage(ModelMap map)
	{
		return "customerLogin";
	}
	@RequestMapping("/customerlogincheck")
	public String customerLoginCheck(ModelMap map,@Valid @ModelAttribute("customer") Customers customer, BindingResult error, @ModelAttribute("product") Products product){
	{
		if(error.hasErrors())
		{
			map.addAttribute("customer", customer);
			return "customerLogin";
		}
		else
		{
			RestTemplate restTemplate = new RestTemplate();
			Customers customer1 = restTemplate.postForObject("http://localhost:9090/loginCustomer",customer,Customers.class);
			if(customer1.getCustomerPswd().equals("dummy"))
			{
				map.addAttribute("error", "Invalid Credentials");
				map.addAttribute("customer", customer);
				return "customerLogin";
			}
			else
			{
				//change this to each category
				map.addAttribute("customer", customer1);
				ProductListDummy response = restTemplate.getForObject("http://localhost:9090/productsList", ProductListDummy.class);
				List<Products> products = response.getProducts();
				System.out.println(products);
				map.addAttribute("productList", products);
				return "customerHomePage";
			}
		}}
	}
	
	@RequestMapping("/customerSignUp")
	public String signUpCustomer(ModelMap map,@Valid @ModelAttribute("customer") Customers customer, BindingResult error)
	{
		if(error.hasErrors())
		{
			map.addAttribute("customer", customer);
			return "customerSignUp";
		}
		RestTemplate restTemplate = new RestTemplate();
		Customers message = restTemplate.postForObject("http://localhost:9090/customerSignUp",customer, Customers.class);
		if(message.getCustomerPswd().equals("dummy"))
		{
			System.out.println("Old Customer");
			map.addAttribute("error", "Customer Already Exists");
			map.addAttribute("customer", customer);
			return "customerSignUp";
		}
		else
		{
			System.out.println("New Customer");
			map.addAttribute("customer", message);
			return "customerHomePage";
		}
	}
	
	@ModelAttribute("customer")
	Customers getCustomer() {
		Customers customer = new Customers();
		return customer;
	}
}
