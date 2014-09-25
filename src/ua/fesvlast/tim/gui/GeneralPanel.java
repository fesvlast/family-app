package ua.fesvlast.tim.gui;

import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import ua.fesvlast.tim.gui.utils.DateLabelFormatter;
import ua.fesvlast.tim.gui.utils.JTextFieldLimit;


public class GeneralPanel extends JPanel{
	
	private final int LABEL_LENGTH=35;
	private final int PERMIT_INPUT_SYMBOLS=50;
	
	private JLabel descLabel;
	private JTextField descField;
	private JLabel dateOfMarriageLabel;
	private JDatePickerImpl dateOfMarriageField;
	private JDatePanelImpl datePanelImpl;
	private UtilDateModel model;
	
	
	public GeneralPanel(){
		
		
		Border innerBorder =BorderFactory.createEtchedBorder();
		Border outerBorder =BorderFactory.createEmptyBorder(10,10,10,10);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		 
		
		descLabel =new JLabel("Description: ");
		descField =new JTextField(LABEL_LENGTH);
		descField.setDocument(new JTextFieldLimit(PERMIT_INPUT_SYMBOLS));
		dateOfMarriageLabel=new JLabel("Date of marriage: ");
	
		
		model = new UtilDateModel();
		datePanelImpl = new JDatePanelImpl(model);
		dateOfMarriageField = new JDatePickerImpl(datePanelImpl, new DateLabelFormatter());
		
	       
		layoutComponents();
		
		
		
	
		
	}

	
	private void layoutComponents(){
		
		
		SpringLayout layout =new SpringLayout();
		
		layout.putConstraint(SpringLayout.WEST, descLabel, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, descLabel, 10, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, descField, 10, SpringLayout.EAST, descLabel);
		layout.putConstraint(SpringLayout.NORTH, descField, 10, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, dateOfMarriageLabel, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, dateOfMarriageLabel, 30, SpringLayout.NORTH, descLabel);
		
		layout.putConstraint(SpringLayout.WEST, dateOfMarriageField, 10, SpringLayout.EAST, dateOfMarriageLabel);
		layout.putConstraint(SpringLayout.NORTH, dateOfMarriageField, 40, SpringLayout.NORTH, this);
		
		
		this.setLayout(layout);

		add(descLabel);
		add(descField);
		add(dateOfMarriageLabel);
		add(dateOfMarriageField);
		

	}
	
	

	public JDatePanelImpl getDatePanel(){
		return datePanelImpl;
	}


	public void disableAllFields() {
		datePanelImpl.setEnabled(false);
		
		descField.setEnabled(false);
		dateOfMarriageField.setEnabled(false);
		//dateOfMarriageField.setVisible(false);
		dateOfMarriageField.getJFormattedTextField().setEditable(false);
		dateOfMarriageField.getJFormattedTextField().setEnabled(false);
		dateOfMarriageField.setVisible(false);
		dateOfMarriageLabel.setVisible(false);
		descLabel.setEnabled(false);
		dateOfMarriageLabel.setEnabled(false);
		descLabel.setVisible(false);
		descField.setVisible(false);
		
	}
	
	public void enableAllFields() {
		datePanelImpl.setEnabled(true);
		descField.setEnabled(true);
		dateOfMarriageField.setEnabled(true);
		dateOfMarriageField.setVisible(true);
		//dateOfMarriageField.getJFormattedTextField().setEditable(true);
		dateOfMarriageField.getJFormattedTextField().setEnabled(true);
		descLabel.setEnabled(true);
		dateOfMarriageLabel.setEnabled(true);
		dateOfMarriageLabel.setVisible(true);
		descLabel.setVisible(true);
		descField.setVisible(true);
	}
	
	public void clearAllFields(){
		descField.setText(null);
		dateOfMarriageField.getJDateInstantPanel().getModel().setValue(null);	
	}


	public String getGeneralDescription() {
		return descField.getText();
	}


	public Date getDateOfMarriage() {
		return (Date)dateOfMarriageField.getModel().getValue();
	}
	
	public void setDateOfMarriage(Date date){
		model.setValue(date);
	}
	
	public void setDescription(String description){
		descField.setText(description);
	}
}
