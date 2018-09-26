package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dto.Admin;
import com.capgemini.dto.CartListDummy;
import com.capgemini.dto.Carts;
import com.capgemini.dto.Customers;
import com.capgemini.dto.Merchants;
import com.capgemini.dto.ProductListDummy;
import com.capgemini.dto.Products;
import com.capgemini.service.ServiceLayer;

@RestController
public class RestConsumerCentral {
	@Autowired
	ServiceLayer ser;
	
	@RequestMapping(value="/c")
	public String check()
	{
		return ser.check();
	}
	@RequestMapping(value="/loginAdmin",method=RequestMethod.POST)
	public Admin consume(@RequestBody Admin admin)
	{
		admin=ser.validateAdmin(admin);
		System.out.println(admin.getAdminName());
		return admin;
	}
	@RequestMapping(value="/loginCustomer",method=RequestMethod.POST)
	public Customers loginCustomer(@RequestBody Customers customer)
	{
		customer=ser.validateCustomerForLogin(customer);
		return customer;
	}
	@RequestMapping(value="/loginMerchant",method=RequestMethod.POST)
	public Merchants loginMerchant(@RequestBody Merchants merchant)
	{
		merchant=ser.validateMerchantForLogin(merchant);
		return merchant;
	}
	@RequestMapping(value="/findProduct",method=RequestMethod.GET)
	public Products findProduct(Integer id)
	{
		return ser.findProduct(id);
	}
	
	@RequestMapping(value="/addToCart",method=RequestMethod.POST)
	public Carts addCart(@RequestBody Carts cart)
	{
		return ser.addToCart(cart);
	}
	
	@RequestMapping(value="/updateQuantity",method=RequestMethod.POST)
	public Carts updateQuantity(@RequestBody Carts cart)
	{
		return ser.updateQuantity(cart);
	}
	
	@RequestMapping(value="/deleteFromCart",method=RequestMethod.POST)
	public Carts deleteFromCart(@RequestBody Carts cart)
	{
		return ser.deleteFromCart(cart);
	}
	
	@RequestMapping(value="/cartsList",method=RequestMethod.GET)
	public CartListDummy cartsList(Integer cid)
	{
		System.out.println(cid);
		CartListDummy c = new CartListDummy();
		c.setCarts(ser.getCartsById(cid));
		return c;
	}
	
	
	@RequestMapping(value="/customerSignUp",method=RequestMethod.POST)
	public Customers signUp(@RequestBody Customers customer){
		customer=ser.createAccount(customer);
		return customer;
	}
	
	@RequestMapping(value="/productsList",method=RequestMethod.GET)
	public ProductListDummy allProducts(){
		ProductListDummy p = new ProductListDummy();
		p.setProducts(ser.getAllProduct());
		return p;
	}
	
/*	@RequestMapping(value="/quote")
	public Quote consumeQuote(){
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		
		return quote;
	}
	
	@RequestMapping(value="/message")
	public Message consumeMessage(){
		System.out.println("******-*-*-*");
		RestTemplate restTemplate = new RestTemplate();
		Message message = restTemplate.getForObject("http://localhost:9090/getmessage?id=1", Message.class);
		
		
		return message;
	}
	
	@RequestMapping(value="/send")
	public Message sendMessage(){
		Message m = new Message();
		m.setText("Java client Posting message");
		m.setSender(new Sender("Java Client"));
		System.out.println(m);
		RestTemplate restTemplate = new RestTemplate();
		Message message = restTemplate.postForObject("http://localhost:9090/receive",m, Message.class);
		
		return message;
	}*/
	
}
