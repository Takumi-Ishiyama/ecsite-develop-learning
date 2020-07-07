package com.example.ecsitedeveloplearning.ec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
				.antMatchers("/","/shop/top/**","/shop/detail/**")
					.permitAll()	//認証を必要としないURL
				.antMatchers("/shop/register/**","/shop/update/**","/shop/delete/**")
					.hasRole("ADMIN")
				.antMatchers("/account/findAll/**")
					.hasRole("USER")
				.anyRequest()
				.authenticated()	//その他は認証済みでないとアクセス不可
			.and()
			.formLogin()
				.loginProcessingUrl("/account/auth")		//認証の処理を行うURL
				.loginPage("/account/login")		//認証ページ
				.failureUrl("/account//login?error")		//認証失敗URL
				.defaultSuccessUrl("/shop/top",false)	//認証成功時URL
				.usernameParameter("userId")				//ログイン画面のinputのuserIdをチェック
				.passwordParameter("password")			//ログイン画面のinputのpasswordをチェック
				.permitAll()	//ログイン画面の設定 アクセス制限なし
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/account/login?logout"))	//ログアウトのURL
				.logoutSuccessUrl("/shop/top")	//ログアウト成功後URL
				.deleteCookies("JSESSIONID")	//ログアウト成功後、cookieのJSESSIONIDを削除する
				.invalidateHttpSession(true);		//ログアウトしたらセッションを無効にする
	}
	/*
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
			.usersByUsernameQuery("select user_id as userId, password as password from rosso_ec.accounts where userId = ?")
			.authoritiesByUsernameQuery("select user_id as userId, user_type as role from rosso_ec.accounts where userId = ?")
			.passwordEncoder(new BCryptPasswordEncoder(256));
	}	
	*/
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
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
