package com.irobinhood.spring.cellphonearena.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String name;
	
	public Phone(){}

	public Phone(String name) {		
		this.name = name;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", name=" + name + "]";
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
	
	
	
}
