package com.example.ecsitedeveloplearning.ec.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecsitedeveloplearning.ec.shop.service.ShopService;

@Controller
@RequestMapping(path="/shop")
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	// Top Page
	@GetMapping("/top")
	public String viewIndex() {
		System.out.println("viewIndex");
		return "shop/top";
	}
	

}
