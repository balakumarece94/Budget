package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.RequestInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	RequestInterceptor reqInterceptor;
@Override
public void addInterceptors(InterceptorRegistry registry) {
	// TODO Auto-generated method stub
	registry.addInterceptor(reqInterceptor);
}
}
