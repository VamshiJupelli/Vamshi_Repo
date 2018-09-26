package com.capgemini.service;

import java.util.List;

import com.capgemini.dto.Admin;
import com.capgemini.dto.Carts;
import com.capgemini.dto.Customers;
import com.capgemini.dto.Merchants;
import com.capgemini.dto.Products;

public interface ServiceLayer
{
	public Admin validateAdmin(Admin admin);
	public Admin findById(int id);
	public Customers createAccount(Customers cusDTO);
	public Customers validateCustomerForLogin(Customers customer);
	public String check();
	public List<Products> getAllProduct();
	public Merchants validateMerchantForLogin(Merchants merchant);
	public Products findProduct(int id);
	public Carts addToCart(Carts cart);
	public Carts updateQuantity(Carts cart);
	public Carts deleteFromCart(Carts cart);
	public List<Carts> getCartsById(Integer cid);
}
