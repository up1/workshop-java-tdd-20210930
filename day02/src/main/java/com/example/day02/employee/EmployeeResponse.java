package com.example.day02.employee;

import org.springframework.stereotype.Component;

public class EmployeeResponse{
	private int id;
	private String name;

	public EmployeeResponse() {
	}

	public EmployeeResponse(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}
