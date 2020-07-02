package com.example.ecsitedeveloplearning.ec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/css/**",
				"/images/**",
				"/js/**",
				"/webjars/**"
				);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/","/shop/top/**","/shop/detail/**").permitAll()	//認証を必要としないURL
				.antMatchers("/shop/register/**","/shop/update/**","/shop/delete/**").hasRole("ADMIN")
				.antMatchers("/account/findAll/**").hasRole("USER")
				.anyRequest().authenticated()	//その他は認証済みでないとアクセス不可
				.and()
			.formLogin()
				.loginProcessingUrl("/account/login")
				.loginPage("/account/signin")
				.failureUrl("/account/error")
				.defaultSuccessUrl("/shop/top",false)
				.usernameParameter("userId")
				.passwordParameter("password")
				.permitAll()	//ログイン画面の設定 アクセス制限なし
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("signout"))
				.logoutSuccessUrl("/shop/top")
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//パスワード
		String password = passwordEncoder().encode("password");
		
		//インメモリ認証を行うための設定
		auth.inMemoryAuthentication()
			.passwordEncoder(passwordEncoder())
			.withUser("user").password(password).roles("USER")
			.and()
			.withUser("admin").password(password).roles("ADMIN");
		}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
