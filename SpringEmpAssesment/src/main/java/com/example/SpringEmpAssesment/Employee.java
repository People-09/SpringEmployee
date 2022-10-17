package com.example.SpringEmpAssesment;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee 
{
    @Id
	long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="name",nullable=false)
	String name;
   @Column(name = "pwd",nullable=true)
   int pwd;
	public int getPwd() {
	return pwd;
}
public void setPwd(int pwd) {
	this.pwd = pwd;
}
	public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
