package ua.fesvlast.tim.model.beans;

import java.io.Serializable;
import java.util.Date;

public class General implements Serializable{
	

	private static final long serialVersionUID = 5318116437238452129L;
	private String description;
	private Date marriageDate;
	
	public General(String description, Date marriageDate) {
		super();
		this.setDescription(description);
		this.setMarriageDate(marriageDate);
	}
	
	public General() {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getMarriageDate() {
		return marriageDate;
	}

	public void setMarriageDate(Date marriageDate) {
		this.marriageDate = marriageDate;
	}
	
	
	

}
