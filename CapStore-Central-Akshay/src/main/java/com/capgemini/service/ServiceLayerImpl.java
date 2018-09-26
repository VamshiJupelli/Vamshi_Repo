package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.DAOLayer;
import com.capgemini.dto.Admin;
import com.capgemini.dto.Carts;
import com.capgemini.dto.Customers;
import com.capgemini.dto.Merchants;
import com.capgemini.dto.Products;

@Service
public class ServiceLayerImpl implements ServiceLayer
{
	@Autowired
	private DAOLayer daoref;

	@Override
	public Admin validateAdmin(Admin admin)
	{
		return daoref.validateAdmin(admin);
	}

	
	@Override
	public Admin findById(int id) {
		return daoref.findById(id);
	}


	@Override
	public Customers createAccount(Customers cusDTO) {
		return daoref.createAccount(cusDTO);
	}


	@Override
	public Customers validateCustomerForLogin(Customers customer) {
		return daoref.validateCustomerForLogin(customer);
	}


	@Override
	public String check() {
		return daoref.check();
	}


	@Override
	public List<Products> getAllProduct() {
		return daoref.getAllProduct();
	}


	@Override
	public Merchants validateMerchantForLogin(Merchants merchant) {
		return daoref.validateMerchantForLogin(merchant);
	}


	@Override
	public Products findProduct(int id) {
		return daoref.findProduct(id);
	}


	@Override
	public Carts addToCart(Carts cart) {
		return daoref.addToCart(cart);
	}


	@Override
	public Carts updateQuantity(Carts cart) {
		return daoref.updateQuantity(cart);
	}


	@Override
	public Carts deleteFromCart(Carts cart) {
		return daoref.deleteFromCart(cart);
	}


	@Override
	public List<Carts> getCartsById(Integer cid) {
		return daoref.getCartsById(cid);
	}
}
