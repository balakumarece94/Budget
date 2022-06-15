package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Budget {
	@Id
	@GeneratedValue
	public int id;
	public String item;
	public int price;
	
	
	public Budget() {
		super();
	}
	public Budget(int id, String item, int price) {
		super();
		this.id = id;
		this.item = item;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
