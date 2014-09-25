package ua.fesvlast.tim.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import ua.fesvlast.tim.gui.utils.WorkDate;

public class WifePanel extends JPanel{
	
	private final int LABEL_LENGTH=40;
	private final int PERMIT_INPUT_SYMBOLS=50;
	
	private JLabel firstNameLabel;
	private JLabel middleNameLabel;
	private JLabel lastNameLabel;
	private JLabel birthDayLabel;
	private JLabel ageLabel;
	
	private JTextField firsNameTextField;
	private JTextField middleNameTextField;
	private JTextField lastNameTextField;
	private JTextField ageTextField;
	
	private JDatePickerImpl birthDayField;
	private UtilDateModel model ;
	
	
		
	public WifePanel(){
		
		Border innerBorder =BorderFactory.createEtchedBorder();
		Border outerBorder =BorderFactory.createEmptyBorder(10,10,10,10);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		firstNameLabel=new JLabel("First Name: ");
		middleNameLabel=new JLabel("Middle Name: ");
		lastNameLabel =new JLabel("Last Name: ");
		birthDayLabel=new JLabel("Birth Day: ");
		ageLabel=new JLabel("Age: ");
		
		firsNameTextField=new JTextField(LABEL_LENGTH);
		firsNameTextField.setDocument(new JTextFieldLimit(PERMIT_INPUT_SYMBOLS));
		
		middleNameTextField=new JTextField(LABEL_LENGTH);
		middleNameTextField.setDocument(new JTextFieldLimit(PERMIT_INPUT_SYMBOLS));
		
		lastNameTextField=new JTextField(LABEL_LENGTH);
		lastNameTextField.setDocument(new JTextFieldLimit(PERMIT_INPUT_SYMBOLS));
		
		model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		birthDayField = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		ageTextField=new JTextField(5);
		ageTextField.setDocument(new JTextFieldLimit(5));
		ageTextField.setToolTipText("Current person's age.");
		ageTextField.setEditable(false);
		
		
		birthDayField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date selectedDate =(Date)birthDayField.getModel().getValue();
				int year =WorkDate.countYers(selectedDate);
				String str =String.valueOf(year);
				ageTextField.setText(str);
				
			}
		});
		
		
		layoutComponents();
		
	}
	
	private void layoutComponents(){
		
		
		SpringLayout layout =new SpringLayout();
		//First row
		layout.putConstraint(SpringLayout.WEST, firstNameLabel, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, firstNameLabel, 10, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, firsNameTextField, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, firsNameTextField, 10, SpringLayout.NORTH, this);
		//Second row
		layout.putConstraint(SpringLayout.WEST, middleNameLabel, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, middleNameLabel, 30, SpringLayout.NORTH, firstNameLabel);
		
		layout.putConstraint(SpringLayout.WEST, middleNameTextField, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, middleNameTextField, 40, SpringLayout.NORTH, this);
		
		//Third row
		layout.putConstraint(SpringLayout.WEST, lastNameLabel, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, lastNameLabel, 30, SpringLayout.NORTH, middleNameLabel);
		
		layout.putConstraint(SpringLayout.WEST, lastNameTextField, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, lastNameTextField, 30, SpringLayout.NORTH, middleNameTextField);
		
		//Forth row
		layout.putConstraint(SpringLayout.WEST, birthDayLabel, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, birthDayLabel, 30, SpringLayout.NORTH, lastNameLabel);
					
		layout.putConstraint(SpringLayout.WEST, birthDayField, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, birthDayField, 30, SpringLayout.NORTH, lastNameTextField);
		
		//Fifth row
		layout.putConstraint(SpringLayout.WEST, ageLabel, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ageLabel, 40, SpringLayout.NORTH, birthDayLabel);
					
		layout.putConstraint(SpringLayout.WEST, ageTextField, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ageTextField, 40, SpringLayout.NORTH, birthDayField);
		
		
		this.setLayout(layout);

		add(firstNameLabel);
		add(firsNameTextField);
		
		add(middleNameLabel);
		add(middleNameTextField);
		
		add(lastNameLabel);
		add(lastNameTextField);
		
		add(birthDayLabel);
		add(birthDayField);
		
		add(ageLabel);
		add(ageTextField);

	}
	
	public void clearAllFields(){
		firsNameTextField.setText(null);
		middleNameTextField.setText(null);
		lastNameTextField.setText(null);
		birthDayField.getJDateInstantPanel().getModel().setValue(null);	
		ageTextField.setText(null);
	}
	
	public String getFirstName() {
		return firsNameTextField.getText();
	}
	public String getMiddleName() {
		return middleNameTextField.getText();
	}
	public String getLastName() {
		return lastNameTextField.getText();
	}
	
	public Date getDateOfBirth() {
		return (Date) birthDayField.getModel().getValue();
	}
	
	public void setFirstName(String firstName){
		firsNameTextField.setText(firstName);
	}
	public void setMiddleName(String middleName){
		middleNameTextField.setText(middleName);
	}
	public void setLastName(String lastName){
		lastNameTextField.setText(lastName);
	}
	
	public void setDateOfBirth(Date date){
		model.setValue(date);
	}
	public void setAgeCountTextField(Date birth){
		if(birth !=null){
			int year =WorkDate.countYers(birth);
			String str =String.valueOf(year);
			ageTextField.setText(str);
		}	
	}
}
