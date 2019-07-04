package com.eksad.latihanspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //sebagai router

public class HelloController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() { //untuk manggil fungsi yg kita buat
		return "Hello Word!";
	}
	
	
	@RequestMapping("/myName") //untuk maping URL
	@ResponseBody
	public String myName(@RequestParam String myName) { //@RequestParam untuk ngisi parameter di myName dengan menggunakan ?=. TIDAK WAJIB UNTUK DIISI
		return "Hello "+myName;
	}
	
	
	@RequestMapping("/namaSaya/{myName}") //untuk maping URL
	@ResponseBody
	public String namaSaya(@PathVariable String myName) { //mengambil dari sebagian URL di atas, yg dlm "{}". WAJIB UNTUK DIISI
		return "Hello "+myName;
	}
	
	
	@RequestMapping("/toGoogle") //untuk maping URL
	@ResponseBody
	public String toGoogle() {
		return "Klik di <a href = 'https:/www.google.com' target='_blank'> sini </a>menuju Google </br> "
				+ "<a href='https:/www.youtube.com' target=_new'> Youtube </a>" ;
	}
	
	
}
