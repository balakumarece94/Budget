package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Budget;
import com.example.demo.repo.BudgetRepo;

@Service
public class BudgetService {

	@Autowired
	BudgetRepo budgetRepo;
	
	public List<Budget> findAllBudget() {
		// TODO Auto-generated method stub
		return budgetRepo.findAll();
	}

	public Budget saveBudget(Budget budget) {
		// TODO Auto-generated method stub
		return budgetRepo.save(budget);
	}
	

}
