package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@SpringBootApplication
public class BmsApplication {

	@Autowired
	private UserRepo userRepo;
	public static void main(String[] args) {
		SpringApplication.run(BmsApplication.class, args);
		System.out.println("Ran the main method......");
	}
	@PostConstruct
	public void init() {
		List<User> users=Stream.of(
				new User(1,"bala","bala","bala@gmail.com"),
				new User(2,"kumar","bala","bala@gmail.com"),
				new User(3,"rajesh","bala","bala@gmail.com")
				).collect(Collectors.toList());
		System.out.println(userRepo.saveAll(users));
		System.out.println("Alll users saved into table");
		System.out.println(userRepo.findByUserName("bala"));
	}
	

}
