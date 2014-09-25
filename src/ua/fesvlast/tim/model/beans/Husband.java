package ua.fesvlast.tim.model.beans;

import java.util.Date;

import ua.fesvlast.tim.model.Person;

public class Husband extends Person {
	
	public Husband(){
		super();
	}
	
	public Husband(String firstName, String middleName, String lastName,
			Date birthDay) {
		super(firstName,middleName,lastName,birthDay);

	}
	
}
