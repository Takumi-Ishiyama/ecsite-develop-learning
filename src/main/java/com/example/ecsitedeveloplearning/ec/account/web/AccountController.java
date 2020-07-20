package com.example.ecsitedeveloplearning.ec.account.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ModelAndView viewAccount(HttpServletRequest request, Principal principal) {
		ModelAndView mv = new ModelAndView("account/viewAccount");
		
		//HttpSession session = request.getSession();
		//SecurityContext secuirtyContext = (SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");
		//Authentication authentication = secuirtyContext.getAuthentication();

		Authentication auth = (Authentication)principal;
		User user = (User)auth.getPrincipal();
		
		AccountDetail accountDetail = new AccountDetail();
		accountDetail = accountService.getAccountDetail(user.getUsername());
		mv.addObject("accountDetail", accountDetail);
		mv.addObject("userId", user.getUsername());
		
		return mv;
	}
	
	@GetMapping("/detail/update")
	public String updateAccount() {
		return "/account/updateAccount";
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
