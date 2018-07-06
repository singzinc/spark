package com.singplayground.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User {
	
	private String name;
    private int age;
    private Map<String, String> address;
    private String[] roles;
    private ArrayList <Team> team;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Map<String, String> getAddress() {
		return address;
	}
	public void setAddress(Map<String, String> address) {
		this.address = address;
	}
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	public ArrayList<Team> getTeam() {
		return team;
	}
	public void setTeam(ArrayList<Team> team) {
		this.team = team;
	}
    
    
    

}
