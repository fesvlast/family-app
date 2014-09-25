package ua.fesvlast.tim.model;

import java.io.Serializable;
import java.util.Date;

public abstract class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9121296467198988285L;
	protected String firstName;
	protected String middleName;
	protected String lastName;
	protected Date birthDay;
	
	public Person(String firstName, String middleName, String lastName,
			Date birthDay) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.birthDay = birthDay;
	}
	
	public Person() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	
	
	
	
}
