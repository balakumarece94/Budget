package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Budget;

@Repository
public interface BudgetRepo extends JpaRepository<Budget, Integer>{

	
}
