package ua.fesvlast.tim.gui.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ua.fesvlast.tim.gui.utils.listeners.ChildEvent;
import ua.fesvlast.tim.gui.utils.listeners.IAddChildListener;
import ua.fesvlast.tim.gui.utils.listeners.IEditChildListener;

public class ChildEditDialog extends JDialog {

	private AddChildPanel editChild;
	private IEditChildListener editChildListener;
	
	private int childId=-1;
	
	
	
	public ChildEditDialog(JFrame parent, String header){
		super(parent, header, false);
		
		editChild=new AddChildPanel();

	
		
		add(editChild);
		setSize(400, 300);
		setModal(true);
		setLocationRelativeTo(parent);
		this.setResizable(false);
		
		
		editChild.getOKButton().addActionListener(new ActionListener() {
			
			private IEditChildListener editListener;

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name =editChild.getNameTextField().getText().trim();
				Integer height =(Integer)editChild.getHeightSpinner().getValue();
				Double  weight= (double)editChild.getWeightSpinner().getValue();
				/*
				 * Fucking Swing crutch
				 * 
				 * */
				String str=weight.toString();
				str =str.substring(0, 3);
				weight=Double.valueOf(str);
				//finish
				
				
				Date date =(Date)editChild.getDateOfBirth().getModel().getValue();
				
				System.out.println(weight);
				
				
				ChildEvent event =new ChildEvent(this, name, height, weight, date);
				
				if(editChildListener !=null){
					editChildListener.rowEdited(childId, event);
					childId=-1;
				}
				
				
				setVisible(false);
			}
		});
		
		editChild.getCloseButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		
		
	}
	
	public void clearDialog(){
		editChild.resetAllFields();
	}
	
	public AddChildPanel getAddChildPanel(){
		return editChild;
	}

	public void setEditChildListener(IEditChildListener listener) {
		
		this.editChildListener=listener;
	}
	
	public void setChildId(int id){
		this.childId=id;
	}
	

}

