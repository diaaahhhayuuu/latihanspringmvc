package com.eksad.latihanspringmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.latihanspringmvc.model.Product;
import com.eksad.latihanspringmvc.repository.ProductRepositoryDAO;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepositoryDAO productRepositoryDAO; //global variable untuk memanggil class ProductRepositoryDAO

	@RequestMapping("/list")
	public String index(Model model) {
		
		List<Product> list = productRepositoryDAO.findAll();
		
		model.addAttribute("listProduct", list);
		
		
		return "list";
	}
	
	@RequestMapping("/add") //@RequestMapping udh default pakai method GET, jadi gak perlu nulis method = RequestMethod.GET lagi
	public String addProduct(Model model) { //
		Product product = new Product(); //wadah untuk menampung dan menambahkan data dan disimpan di add.html th:object
		
		model.addAttribute("product", product);
		
		return "add";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Product product) {
		productRepositoryDAO.save(product);
		
		return "redirect:/product/list";
	}
}
