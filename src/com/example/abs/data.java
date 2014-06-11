package com.example.abs;

public class data {
	
	private String name;
	private String release;
	
	data(int i,String n,String p)
	{
		this.name = n;
		this.release = p;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPh() {
		return release;
	}
}
