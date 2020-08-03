package com.example.ecsitedeveloplearning.ec.account.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecsitedeveloplearning.ec.account.model.AccountDetail;
import com.example.ecsitedeveloplearning.ec.account.service.AccountService;

@Controller
@RequestMapping(path="/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;


	//ログインページを表示
	@GetMapping("/login")
	public String viewLogin() {
		System.out.println("viewLogin");
		return "account/login";
	}
	
	//アカウントページを表示
	@GetMapping("/detail")
	public ModelAndView viewAccount(Principal principal) {
		ModelAndView mv = new ModelAndView("account/viewAccount");
		
		//HttpSession session = request.getSession();
		//SecurityContext secuirtyContext = (SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");
		//Authentication authentication = secuirtyContext.getAuthentication();

		AccountDetail accountDetail = getAccountDetail(principal);
		mv.addObject("accountDetail", accountDetail);
	
		return mv;
	}
	
	@GetMapping("/detail/update/{editType}")
	public ModelAndView updateAccount(
			Principal principal,
			@PathVariable("editType") String editType
	) {
		ModelAndView mv = new ModelAndView("/account/updateAccount");

		AccountDetail accountDetail = getAccountDetail(principal);
		mv.addObject("accountDetail", accountDetail);
		mv.addObject("editType", editType);
		return mv;
	}

	@PostMapping("/detail/update/save")
	public  ModelAndView saveAccount(
//			@ModelAttribute AccountDetail accountDetail
			Principal principal,
			@RequestParam("userId") String userId,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("postcode1") String postcode1,
			@RequestParam("postcode2") String postcode2,
			@RequestParam("address1") String address1,
			@RequestParam("address2") String address2,
			@RequestParam("buildingName") String buildingName,
			@RequestParam("telephoneNumber1") String telephoneNumber1,
			@RequestParam("telephoneNumber2") String telephoneNumber2,
			@RequestParam("telephoneNumber3") String telephoneNumber3
	) {
		String postcode = postcode1 + "-" +  postcode2;
		String telephoneNumber = telephoneNumber1 + "-" + telephoneNumber2 + "-" +  telephoneNumber3;
		
		accountService.updateAccount(userId, firstName,lastName,postcode,address1,address2,buildingName,telephoneNumber);
		ModelAndView mv = new ModelAndView("/account/viewAccount");

		AccountDetail accountDetail = getAccountDetail(principal);
		mv.addObject("accountDetail", accountDetail);
		return mv;
	}	
	
	private AccountDetail getAccountDetail(Principal principal) {
		Authentication auth = (Authentication)principal;
		User user = (User)auth.getPrincipal();

		AccountDetail accountDetail = new AccountDetail();
		accountDetail = accountService.getAccountDetail(user.getUsername());
		return accountDetail;
	}

	
	
	
	/**
	//Top Page
	@GetMapping("/findAll")
	public String getAccounts() {
		List<Account> findAll = accountService.findAll();
		System.out.println("findAll :" + findAll);
		System.out.println("viewLogin");
		return "account/login";
	}


	//認証処理
	@PostMapping("/auth")
	public String authAccount(
				@RequestParam("userId") String userId,
				@RequestParam("password") String password
			) {
		/*
		if(accountService.authCheck(userId, password).equals(null)) {
			return "account/login?error";
		}
		
		accountService.getUserProfile(userId, password);
		return "redirect:/shop/top";
	}
	*/
}
