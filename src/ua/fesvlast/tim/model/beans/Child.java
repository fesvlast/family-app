package ua.fesvlast.tim.model.beans;

import java.io.Serializable;
import java.util.Date;

public class Child implements Serializable {
	
	private static final long serialVersionUID = 7112374205467421228L;
	private static int count=0;
	
	private int id;
	private String name;
	private int height;
	private double weight;
	
	private Date birthDay;
	
	
	public Child(String name, int height, double weight, Date birthDay) {
		super();
		this.name = name;
		this.height = height;
		this.weight=weight;
		this.birthDay = birthDay;
		
		this.id = count;
		count++;
	}
	
	public Child() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public int getId() {
		return id;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

}
