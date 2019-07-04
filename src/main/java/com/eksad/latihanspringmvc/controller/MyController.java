package com.eksad.latihanspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/my")
public class MyController {
	
	@RequestMapping("hello")
	public String hello() {
		return "hello"; //karena pakai thymeleaf, dia nyari String itu sebagai pemanggil file .html. makanya yg di dlm kutip kudu sama dengan nama file html nya
	}
	

	@RequestMapping("myName")
	public String myName(@RequestParam String name, Model model) { //model = sebagai penghubung antara java ke source html
		
		model.addAttribute("name", name); //"name" adalah suatu nama paraeter yg mau dikirim ke file html
		
		return "myname"; 
	}
}
