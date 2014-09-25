package ua.fesvlast.tim.gui.dialogs;

import javax.swing.JPanel;








import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.text.Document;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import ua.fesvlast.tim.gui.utils.DateLabelFormatter;
import ua.fesvlast.tim.gui.utils.JTextFieldLimit;

public class AddChildPanel extends JPanel {
	
	private final int PERMIT_INPUT_SYMBOLS=50;
	
	private JButton okButton;
	private JButton cancelButton;
	
	private JTextField nameField;
	
	
	private JLabel nameLabel;
	private JLabel heightLabel;
	private JLabel weightLabel;
	private JLabel birthDayLabel;
	
	
	private JSpinner heightSpinner;
	private JSpinner weightSpinner;
	private SpinnerNumberModel spinnerModelHeight;
	private SpinnerNumberModel spinnerModelWeight;
	
	private JDatePickerImpl dateOfBirthField;
	private UtilDateModel model ;
	
	
	public AddChildPanel(){
		
		
		Border innerBorder =BorderFactory.createEtchedBorder();
		Border outerBorder =BorderFactory.createEmptyBorder(10,10,10,10);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		
		nameField =new JTextField(20);
		nameField.setDocument(new JTextFieldLimit(PERMIT_INPUT_SYMBOLS));
		
		nameLabel=new JLabel("Name: ");
		heightLabel=new JLabel("Height (cm): ");
		weightLabel=new JLabel("Weight (kg): ");
		birthDayLabel=new JLabel("Birth Day: ");
		
		
		
		okButton =new JButton("OK");
		cancelButton=new JButton("Cancel");
		
		spinnerModelHeight =new SpinnerNumberModel(0,0, 99, 1);
		heightSpinner =new JSpinner(spinnerModelHeight);
		
		spinnerModelWeight =new SpinnerNumberModel(0,0.0, 10, 0.1);
		weightSpinner=new JSpinner(spinnerModelWeight);
		
		 model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		dateOfBirthField = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
	
		
		layoutComponents();

	}
	
	
	public JButton getOKButton(){
		return okButton;
	}
	
	public JButton getCloseButton(){
		return cancelButton;
	}
	
	public JTextField getNameTextField(){
		return nameField;
	}
	
	public JSpinner getHeightSpinner(){
		return heightSpinner;
	}
	
	public JSpinner getWeightSpinner(){
		return weightSpinner;
	}
	
	public JDatePickerImpl getDateOfBirth(){
		return dateOfBirthField;
	}
	
	
public void resetAllFields(){
		nameField.setText(null);
		heightSpinner.getModel().setValue(0);
		weightSpinner.getModel().setValue(0.0);
		dateOfBirthField.getModel().setSelected(false);
	}

public void setChildFields(String name, int height, double weight, Date date, int row){
	nameField.setText(name);
	heightSpinner.setValue(height);
	weightSpinner.setValue(weight);
	model.setValue(date);
}
private void layoutComponents(){
		
		
		SpringLayout layout =new SpringLayout();
		//First row
		layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, nameLabel, 20, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, nameField, 20, SpringLayout.NORTH, this);
		
		//Second row
		layout.putConstraint(SpringLayout.WEST, heightLabel, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, heightLabel, 30, SpringLayout.NORTH, nameLabel);
		
		layout.putConstraint(SpringLayout.WEST, heightSpinner, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, heightSpinner, 30, SpringLayout.NORTH, nameLabel);
		
		//Third row
		layout.putConstraint(SpringLayout.WEST, weightLabel, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, weightLabel, 30, SpringLayout.NORTH, heightLabel);
		
		layout.putConstraint(SpringLayout.WEST, weightSpinner, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, weightSpinner, 30, SpringLayout.NORTH, heightSpinner);
		
		//Forth row
		layout.putConstraint(SpringLayout.WEST, birthDayLabel, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, birthDayLabel, 30, SpringLayout.NORTH, weightLabel);
				
		layout.putConstraint(SpringLayout.WEST,dateOfBirthField, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, dateOfBirthField, 30, SpringLayout.NORTH, weightLabel);
		
		//Fifth row
		layout.putConstraint(SpringLayout.WEST, okButton, 230, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, okButton, 210, SpringLayout.NORTH, this);
						
		layout.putConstraint(SpringLayout.WEST,cancelButton, 285, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, cancelButton, 210, SpringLayout.NORTH, this);
		
		
		this.setLayout(layout);

		add(nameLabel);
		add(nameField);
		
		add(heightLabel);
		add(heightSpinner);
		
		add(weightLabel);
		add(weightSpinner);
		
		add(birthDayLabel);
		add(dateOfBirthField);
		
		add(okButton);
		add(cancelButton);

	}

}
