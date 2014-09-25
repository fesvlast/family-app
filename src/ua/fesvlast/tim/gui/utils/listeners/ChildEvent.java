package ua.fesvlast.tim.gui.utils.listeners;

import java.util.Date;
import java.util.EventObject;

public class ChildEvent extends EventObject {
	
	private String name;
	private int height;
	private double weight;
	private Date date;
	private int childId;
	

	public ChildEvent(Object source, String name, int height, double weight,
			Date date) {
		super(source);
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.date = date;
		
	//	ChildEvent.System.out.println("Weight from form event: "+weight);
	}
	
	public ChildEvent(Object source, String name, int height, double weight,
			Date date, int id) {
		super(source);
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.date = date;
		this.childId=id;
		
	//	ChildEvent.System.out.println("Weight from form event: "+weight);
	}


	public ChildEvent(Object source) {
		super(source);
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


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getChildId() {
		return childId;
	}


	public void setChildId(int childId) {
		this.childId = childId;
	}
	
}
