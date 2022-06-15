package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.service.MyUserDetailService;
import com.example.demo.utils.JwtTokenUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	JwtTokenUtil jwtToken;
	@Autowired
	MyUserDetailService myUserDS;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token="",username="";
		System.out.println("Do Filter in filter");
		String authHeader=request.getHeader("Authorization");
		if (authHeader!=null && authHeader.startsWith("Bearer")) {
			token=authHeader.substring(7);
			System.out.println("substring token: "+token);
			username=jwtToken.getUsernameFromToken(token);
			System.out.println("username token: "+username);
		if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails=myUserDS.loadUserByUsername(username);
		if (jwtToken.validateToken(token, userDetails)) {
			UsernamePasswordAuthenticationToken upAuthToken=new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
			upAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(upAuthToken);
		}
		}

		}
		
		filterChain.doFilter(request, response);			
	}

}
