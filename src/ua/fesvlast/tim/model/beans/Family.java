package ua.fesvlast.tim.model.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Family implements Serializable {
	
	private static final long serialVersionUID = 2841032489301796442L;
	
	private General general;
	private Husband husband;
	private Wife wife;
	private List<Child> children =new LinkedList<Child>();
	
	public Family(General general, Husband husband, Wife wife,
			List<Child> children) {
		super();
		this.setGeneral(general);
		this.setHusband(husband);
		this.setWife(wife);
		this.setChildren(children);
	}
	
	public Family(){
		general=new General();
		husband=new Husband();
		wife=new Wife();
	}

	public General getGeneral() {
		return general;
	}

	public void setGeneral(General general) {
		this.general = general;
	}

	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
	}

	public Wife getWife() {
		return wife;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}
	

}
