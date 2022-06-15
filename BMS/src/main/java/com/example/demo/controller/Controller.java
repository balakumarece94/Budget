package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuthRequest;
import com.example.demo.entity.Budget;
import com.example.demo.service.BudgetService;
import com.example.demo.utils.JwtTokenUtil;

@RestController
public class Controller {

	@Autowired
	BudgetService budgetService;
	
	@Autowired
	private JwtTokenUtil jwtToken;
	
	@Autowired
	private AuthenticationManager authMgr;
	
	@PostMapping("/auth")
	public String generateToken(@RequestBody AuthRequest auth) throws Exception {
//		AuthRequest auth=new AuthRequest(auth.getUserName(),auth.getPassword());
		System.out.println("calling post method to generat token");
		try {
			authMgr.authenticate(
					new UsernamePasswordAuthenticationToken(auth.getUserName(), auth.getPassword())
					);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Invalid username/psd");
		}
		return jwtToken.generateToken(auth.getUserName());
	}
	
	@GetMapping("/findAllBudget")
	public List<Budget> findAllBudget(){
		
		return budgetService.findAllBudget();
		
	}	
	
	@GetMapping("/saveBudget")
	public List<Budget> saveBudgetGet() {
		ArrayList<Budget> budget=new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			Budget b=new Budget(i,"tea"+i,12+1);
			budget.add(budgetService.saveBudget(b));
		}
		return budget;
		
	}

	
	@PostMapping("/saveBudget")
	public Budget saveBudget(@RequestBody Budget budget) {
		return budgetService.saveBudget(budget);
		
	}
}
