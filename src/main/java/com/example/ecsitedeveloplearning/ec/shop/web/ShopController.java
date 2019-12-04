package com.example.ecsitedeveloplearning.ec.shop.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecsitedeveloplearning.ec.shop.model.Product;
import com.example.ecsitedeveloplearning.ec.shop.model.Category;
import com.example.ecsitedeveloplearning.ec.shop.service.ShopService;

@Controller
@RequestMapping(path="/shop")
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@Value("${upload.image.path}")
	private String uploadImagePath;
	
	// Top Page
	@GetMapping("/top")
	public ModelAndView viewTop() {
		ModelAndView mv = new ModelAndView("shop/top");
		List<Product> products = shopService.findAllBycategory(1);
		List<Category> categories = new shopService.findCategories();
		mv.addObject("products", products);
		mv.addObject("categories", categories);
		
		return mv;
	}
	

}
