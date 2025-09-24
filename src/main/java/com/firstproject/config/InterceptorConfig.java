package com.firstproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.firstproject.interceptors.AuthInterceptor;
import com.firstproject.interceptors.LoggedOutUsersOnlyInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	AuthInterceptor authInterceptor;
	
	@Autowired
	LoggedOutUsersOnlyInterceptor loggedOutUsersOnlyInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		//interceptor for Authorized pages so that only logged in user's can access those pages
		registry.addInterceptor(authInterceptor).addPathPatterns("/**").excludePathPatterns("/user/login","/user/register");
		
		//interceptor for login & register page so that only logged out user's can access these pages
		registry.addInterceptor(loggedOutUsersOnlyInterceptor).addPathPatterns("/user/login","/user/register");
	}

}
