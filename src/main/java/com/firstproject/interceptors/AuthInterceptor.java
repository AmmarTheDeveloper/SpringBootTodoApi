package com.firstproject.interceptors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AuthInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			
		//avoiding the creation of session for unauthenticated user's bydefault if user is new session is created automatically but by passing false it disables it
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("userId") != null) return true;
		
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED ,"Unauthorized - Please login");
	}

}
