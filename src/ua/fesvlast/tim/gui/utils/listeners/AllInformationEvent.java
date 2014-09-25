package ua.fesvlast.tim.gui.utils.listeners;

import java.util.Date;
import java.util.EventObject;

public class AllInformationEvent extends EventObject {
	
	

	private String generalDescription;
	private Date dateOfMarriage;
	
	private String wifeFirstName;
	private String wifeMiddleName;
	private String wifeLastName;
	private Date wifeBirthDate;
	
	private String husbandFirstName;
	private String husbandMiddleName;
	private String husbandLastName;
	private Date husbandBirthDate;
	
	
	public AllInformationEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	public String getGeneralDescription() {
		return generalDescription;
	}


	public void setGeneralDescription(String generalDescription) {
		this.generalDescription = generalDescription;
	}


	public Date getDateOfMarriage() {
		return dateOfMarriage;
	}


	public void setDateOfMarriage(Date dateOfMarriage) {
		this.dateOfMarriage = dateOfMarriage;
	}


	public String getWifeFirstName() {
		return wifeFirstName;
	}


	public void setWifeFirstName(String wifeFirstName) {
		this.wifeFirstName = wifeFirstName;
	}


	public String getWifeMiddleName() {
		return wifeMiddleName;
	}


	public void setWifeMiddleName(String wifeMiddleName) {
		this.wifeMiddleName = wifeMiddleName;
	}


	public String getWifeLastName() {
		return wifeLastName;
	}


	public void setWifeLastName(String wifeLastName) {
		this.wifeLastName = wifeLastName;
	}


	public Date getWifeBirthDate() {
		return wifeBirthDate;
	}


	public void setWifeBirthDate(Date wifeBirthDate) {
		this.wifeBirthDate = wifeBirthDate;
	}


	public String getHusbandFirstName() {
		return husbandFirstName;
	}


	public void setHusbandFirstName(String husbandFirstName) {
		this.husbandFirstName = husbandFirstName;
	}


	public String getHusbandMiddleName() {
		return husbandMiddleName;
	}


	public void setHusbandMiddleName(String husbandMiddleName) {
		this.husbandMiddleName = husbandMiddleName;
	}


	public String getHusbandLastName() {
		return husbandLastName;
	}


	public void setHusbandLastName(String husbandLastName) {
		this.husbandLastName = husbandLastName;
	}


	public Date getHusbandBirthDate() {
		return husbandBirthDate;
	}


	public void setHusbandBirthDate(Date husbandBirthDate) {
		this.husbandBirthDate = husbandBirthDate;
	}



}
