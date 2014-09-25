package ua.fesvlast.tim.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import ua.fesvlast.tim.gui.utils.listeners.AllInformationEvent;
import ua.fesvlast.tim.gui.utils.listeners.ChildEvent;
import ua.fesvlast.tim.model.DataStorage;
import ua.fesvlast.tim.model.beans.Child;
import ua.fesvlast.tim.model.beans.Family;
import ua.fesvlast.tim.model.beans.General;
import ua.fesvlast.tim.model.beans.Husband;
import ua.fesvlast.tim.model.beans.Wife;

public class Controller {
	
	DataStorage ds= new DataStorage();
	
	public List<Child> getChildren(){
		return ds.getChildren();
	}
	
	public void addChild(ChildEvent ev){
		String name =ev.getName();
		int height =ev.getHeight();
		Double weight =ev.getWeight();
		//System.out.println("Controller"+weight);
		Date date =ev.getDate();
		Child child =new Child(name, height, weight, date);
		ds.addChild(child);
		//System.out.println(child.getId()+" "+child.getName()+" "+child.getWeight()+" "+child.getBirthDay());
			
	}


	public void removeChild(int index) {
		ds.removeChild(index);
		
	}


	public ChildEvent getChild(int index) {
		Child child=ds.getCurrentChild(index);
		ChildEvent event =new ChildEvent(this);
		event.setDate(child.getBirthDay());
		event.setHeight(child.getHeight());
		event.setWeight(child.getWeight());
		event.setName(child.getName());
		event.setChildId(child.getId());
		return event;
		
	}


	public void editChild(int childId, ChildEvent ev) {
		Child current =new Child(ev.getName(), ev.getHeight(), ev.getWeight(), ev.getDate());
		
		ds.editChild(childId, current);
		
	}


	public void removeAllChildren() {
		ds.removeAllChildren();
		
	}
	
	public void saveToFile(File file) throws IOException, ClassNotFoundException{
		ds.saveToFile(file);
	}
	
	public void loadFromFile(File file) throws ClassNotFoundException, IOException{
		ds.loadFromFile(file);
	}


	public void setFamily(AllInformationEvent ev) {
		Family current =ds.getFamily();
		if(current == null){
			System.out.println("Is null");
		}

			current.getGeneral().setDescription(ev.getGeneralDescription());
			current.getGeneral().setMarriageDate(ev.getDateOfMarriage());
			
			current.getHusband().setFirstName(ev.getHusbandFirstName());
			current.getHusband().setMiddleName(ev.getHusbandMiddleName());
			current.getHusband().setLastName(ev.getHusbandLastName());
			current.getHusband().setBirthDay(ev.getHusbandBirthDate());
			
			current.getWife().setFirstName(ev.getWifeFirstName());
			current.getWife().setMiddleName(ev.getWifeMiddleName());
			current.getWife().setLastName(ev.getWifeLastName());
			current.getWife().setBirthDay(ev.getWifeBirthDate());
					
		System.out.println(current.getGeneral().getDescription());
	}
	
	public AllInformationEvent getAllInformation(){
		AllInformationEvent ev=new AllInformationEvent(this);
		Family current =ds.getFamily();
		
		ev.setGeneralDescription(current.getGeneral().getDescription());
		ev.setDateOfMarriage(current.getGeneral().getMarriageDate());
		
		ev.setHusbandFirstName(current.getHusband().getFirstName());
		ev.setHusbandMiddleName(current.getHusband().getMiddleName());
		ev.setHusbandLastName(current.getHusband().getMiddleName());
		ev.setHusbandBirthDate(current.getHusband().getBirthDay());
		
		ev.setWifeFirstName(current.getWife().getFirstName());
		ev.setWifeMiddleName(current.getWife().getMiddleName());
		ev.setWifeLastName(current.getWife().getMiddleName());
		ev.setWifeBirthDate(current.getWife().getBirthDay());
		return ev;
	}


}
