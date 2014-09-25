package ua.fesvlast.tim.gui.childGui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ua.fesvlast.tim.gui.utils.DateLabelFormatter;
import ua.fesvlast.tim.model.beans.Child;

public class ChildTableModel extends AbstractTableModel{
	
	private List<Child> ds;
	private String[] colNames={"¹", "Name", "Height (cm)", "Weight (kg)", "Date"};
	
	private List<Integer> pos;
	
	public ChildTableModel() {
		
	}
	
	
	
	public void setData(List<Child> ds){
		this.ds=ds;
		
		pos=new ArrayList<Integer>();
		for(int i=0; i<ds.size(); i++){
			pos.add(i);
		}
	}

	@Override
	public int getRowCount() {
		int rows=0;
		if(ds !=null){
			rows=ds.size();
		}
		
		return rows;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		Child child =ds.get(row);
		SimpleDateFormat form =new SimpleDateFormat("MM/dd/yyyy");
		if(child !=null){
			switch (col) {
			case 0:
				return pos.get(row);
			case 1:
				return child.getName();
			case 2:
				return child.getHeight();
			case 3:
				return child.getWeight();
			case 4:
					if(child.getBirthDay()!=null){
						return form.format(child.getBirthDay());
					}else{
						return child.getBirthDay();
					}	
			}
		}
	
		return null;
	}
	
	public String getColumnName(int col) {
		return colNames[col];
	}
	
	

}
