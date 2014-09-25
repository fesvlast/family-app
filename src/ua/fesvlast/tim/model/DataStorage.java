package ua.fesvlast.tim.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;

import ua.fesvlast.tim.model.beans.Child;
import ua.fesvlast.tim.model.beans.Family;

public class DataStorage {
	
	private Family family;
	
	public DataStorage(){
		
		family=new Family();
		//family.getChildren().add(new Child("John", 22, 2.3d, new Date()));
		//family.getChildren().add(new Child("Tim", 28, 2.3d, new Date()));
	}
	
	public void addChild(Child child){
		family.getChildren().add(child);
	}
	
	public List<Child> getChildren(){
		return Collections.unmodifiableList(family.getChildren());
	}

	public void removeChild(int index) {
		family.getChildren().remove(index);
	}

	public Child getCurrentChild(int index) {
		return family.getChildren().get(index);
		
	}


	public void editChild(int childId, Child current) {	
		List<Child> children= family.getChildren();	
		for(Child child: children){
			if(childId ==child.getId()){
				child.setBirthDay(current.getBirthDay());
				child.setName(current.getName());
				child.setHeight(current.getHeight());
				child.setWeight(current.getWeight());
				break;
			}
		}
		
	}

	public void removeAllChildren() {
		family.getChildren().clear();
		
	}
	
	public void saveToFile(File file) throws IOException, ClassNotFoundException{
	
		FileOutputStream fos =null;
		ObjectOutputStream oos=null;
		
		file =FileFormatter.formatFile(file);
			fos = new FileOutputStream(file);
			oos =new ObjectOutputStream(fos);
			oos.writeObject(family);
			oos.close();
	}
	
	public void loadFromFile(File file) throws ClassNotFoundException,IOException{
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		file =FileFormatter.formatFile(file);
			fis=new FileInputStream(file);
			ois =new ObjectInputStream(fis);
			setFamily((Family)ois.readObject());
			ois.close();	
	}
	
	public void setFamily(Family family){
		this.family=family;
	}

	public Family getFamily() {
		return family;
	}
	
	
	

}
