package ua.fesvlast.tim.gui.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ua.fesvlast.tim.gui.utils.listeners.ChildEvent;
import ua.fesvlast.tim.gui.utils.listeners.IAddChildListener;

public class ChildDialog extends JDialog {

	private AddChildPanel addChild;
	private IAddChildListener listener;
	
	public ChildDialog(JFrame parent, String header){
		super(parent, header, false);
		
		addChild=new AddChildPanel();

		add(addChild);
		setSize(400, 300);
		setModal(true);
		setLocationRelativeTo(parent);
		this.setResizable(false);
		
		
		addChild.getOKButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name =addChild.getNameTextField().getText().trim();
				Integer height =(Integer)addChild.getHeightSpinner().getValue();
				Double  weight= (double)addChild.getWeightSpinner().getValue();
				/*
				 * Fucking Swing crutch
				 * 
				 * */
				String str=weight.toString();
				str =str.substring(0, 3);
				weight=Double.valueOf(str);
			//	System.out.println(str);
				//finish
				
				
				Date date =(Date)addChild.getDateOfBirth().getModel().getValue();
				
				//System.out.println(weight);
				
				
				ChildEvent event =new ChildEvent(this, name, height, weight, date);
				
				if(listener !=null){
					listener.formEventOccured(event);
				}
				
				
				setVisible(false);
			}
		});
		
		addChild.getCloseButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		
		
	}
	
public void setFormListener(IAddChildListener listener){
		
		this.listener=listener;
	}
	
	public void clearDialog(){
		addChild.resetAllFields();
	}
	
	public AddChildPanel getAddChildPanel(){
		return addChild;
	}



}

