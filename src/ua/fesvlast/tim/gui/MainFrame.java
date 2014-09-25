package ua.fesvlast.tim.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import ua.fesvlast.tim.controller.Controller;
import ua.fesvlast.tim.gui.childGui.TablePanel;
import ua.fesvlast.tim.gui.dialogs.ChildDialog;
import ua.fesvlast.tim.gui.dialogs.ChildEditDialog;
import ua.fesvlast.tim.gui.utils.DontChooseRowException;
import ua.fesvlast.tim.gui.utils.FamilyFileFilter;
import ua.fesvlast.tim.gui.utils.listeners.AllInformationEvent;
import ua.fesvlast.tim.gui.utils.listeners.ChildEvent;
import ua.fesvlast.tim.gui.utils.listeners.IAddAllInformationListener;
import ua.fesvlast.tim.gui.utils.listeners.IAddChildListener;
import ua.fesvlast.tim.gui.utils.listeners.IChildrenListener;
import ua.fesvlast.tim.gui.utils.listeners.IEditChildListener;
import ua.fesvlast.tim.gui.utils.listeners.ILoadAllInformationListener;
import ua.fesvlast.tim.gui.utils.listeners.IRemoveAllChildrenListener;


public class MainFrame extends JFrame {
	
	public  boolean isOkCreateNewPressed =false;
	
	private ToolBar toolBar;
	private JFileChooser fileChooser;
	
	
	private JTabbedPane tabPane;
	private GeneralPanel generalPanel;
	private HusbandPanel husbandPanel;
	private WifePanel wifePanel;
	
	private TablePanel tablePanel;
	private Controller controller;
	
	private ChildDialog dialogAdd;
	private ChildEditDialog dialogEdit;

	private IAddAllInformationListener addAllInformationListener;
	
	public MainFrame(){
		super("Family Test Application.");
		
		controller=new Controller();
		
		fileChooser=new JFileChooser();
		fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
		fileChooser.addChoosableFileFilter(new FamilyFileFilter());
		
		dialogAdd =new ChildDialog(this, "Add child dialog");
		dialogEdit =new ChildEditDialog(this, "Edit child dialog");
		
		toolBar=new ToolBar(MainFrame.this);
		

		tablePanel =new TablePanel(this);
		
		
		tabPane =new JTabbedPane();
		generalPanel=new GeneralPanel();
		husbandPanel=new HusbandPanel();
		wifePanel=new WifePanel();

		
		tabPane.addTab("General", generalPanel);
		tabPane.addTab("Husband", husbandPanel);
		tabPane.addTab("Wife", wifePanel);
		tabPane.addTab("Children", tablePanel);
		
		
		
		 disableAllFields();
		add(tabPane);
		add(toolBar, BorderLayout.NORTH);
		setMinimumSize(new Dimension(600, 300));
		//setResizable(false);
		setSize(600, 300);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		
		

		tablePanel.getBar().getRemoveRowButton().setEnabled(false);
		tablePanel.getBar().getEditRowButton().setEnabled(false);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.out.println("Window closing");
				
				int action =JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to exit the application?",
						"Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
				if(action ==JOptionPane.OK_OPTION){
					dispose();
					System.gc();
				}	
			}
			
		});
		

		tablePanel.setChildrenTableListener(new IChildrenListener(){
			public void rowDeleted(int row){
				controller.removeChild(row);
				
				if(controller.getChildren().isEmpty()){
					tablePanel.getBar().getRemoveRowButton().setEnabled(false);
					tablePanel.getBar().getEditRowButton().setEnabled(false);
				}
				
			}
		});
		
		dialogEdit.setEditChildListener(new IEditChildListener() {
			
			@Override
			public void rowEdited(int childId, ChildEvent ev) {
				System.out.println("Edit child dialog listener");
				controller.editChild(childId, ev);
				
				tablePanel.setData(controller.getChildren());
				tablePanel.refresh();
				
			}
		});
		

		dialogAdd.setFormListener(new IAddChildListener() {
			@Override
			public void formEventOccured(ChildEvent ev) {
				//fields with data
				
				controller.addChild(ev);
				tablePanel.setData(controller.getChildren());
				tablePanel.refresh();
				
				tablePanel.getBar().getRemoveRowButton().setEnabled(true);
				tablePanel.getBar().getEditRowButton().setEnabled(true);
			}
		});
		
		tablePanel.getBar().getCreateRowButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogAdd.clearDialog();
				dialogAdd.setVisible(true);
			}
		});
		
		// Edit Child listener
		tablePanel.getBar().getEditRowButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//dialogEdit.clearDialog();
				int row =tablePanel.getChildTable().getSelectedRow();
				try{	 
					if(row ==-1){
						throw new DontChooseRowException();	
					}
					System.out.println("Selected row "+row);
					ChildEvent ev = controller.getChild(row);
					dialogEdit.getAddChildPanel().setChildFields(ev.getName(), ev.getHeight(), ev.getWeight(), ev.getDate(), row);
					dialogEdit.setChildId(ev.getChildId());
					dialogEdit.setVisible(true);
				}catch(DontChooseRowException ex){
					JOptionPane.showMessageDialog(MainFrame.this, "Select the row, please.", "Edit row message", JOptionPane.INFORMATION_MESSAGE);
				}			
			}
		});
		
		toolBar.getNewBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!toolBar.getSaveBtn().isEnabled()){
					enableAllFields();
				}else{
					int action =JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to clear all these fields?",
							"Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
					if(action ==JOptionPane.OK_OPTION){
						isOkCreateNewPressed=true;
						enableAllFields();
						clearAllApplicationFields();	
					}else{
						isOkCreateNewPressed=false;
					}	
				}	
			}
		});
		
		// Remove all children listener
		tablePanel.setRemoveAllChildrenListener(new IRemoveAllChildrenListener(){
			public void removeAllChildren(){	
					if(isOkCreateNewPressed){
						controller.removeAllChildren();
					}
			}
		});
		////////////////////////////////////////////////////////////////////////////////
		
	
		
		toolBar.setAllInformationListener(new IAddAllInformationListener(){
			
			public void getAllInformation(){
				AllInformationEvent ev =new AllInformationEvent(toolBar);
				System.out.println("All information listener");
			    ev.setGeneralDescription(generalPanel.getGeneralDescription());
				ev.setDateOfMarriage(generalPanel.getDateOfMarriage());
				
				ev.setHusbandFirstName(husbandPanel.getFirstName());
				ev.setHusbandMiddleName(husbandPanel.getMiddleName());
				ev.setHusbandLastName(husbandPanel.getLastName());
				ev.setHusbandBirthDate(husbandPanel.getDateOfBirth());
				
				ev.setWifeFirstName(wifePanel.getFirstName());
				ev.setWifeMiddleName(wifePanel.getMiddleName());
				ev.setWifeLastName(wifePanel.getLastName());
				ev.setWifeBirthDate(wifePanel.getDateOfBirth());
				
				controller.setFamily(ev);
				

				if(fileChooser.showSaveDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION){
					System.out.println(fileChooser.getSelectedFile());
					
					try {
						controller.saveToFile(fileChooser.getSelectedFile());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, "Could not save data to file.",
								"Error", JOptionPane.ERROR_MESSAGE);
					} catch (ClassNotFoundException e) {
						JOptionPane.showMessageDialog(MainFrame.this, "File wasn't found!",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}	
			}
		});
		
		
		toolBar.setAllOpenInformationListener(new ILoadAllInformationListener(){

			@Override
			public void loadAllInformation() {
				
				if(fileChooser.showOpenDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION){
					//System.out.println(fileChooser.getSelectedFile());
					enableAllFields();
					try {
						controller.loadFromFile(fileChooser.getSelectedFile());
						tablePanel.setData(controller.getChildren());
						
						tablePanel.refresh();
					} catch (ClassNotFoundException e) {
						JOptionPane.showMessageDialog(MainFrame.this, "File wasn't found!",
								"Error", JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, "Could not load data from file.",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
					
					AllInformationEvent ev=controller.getAllInformation();
					generalPanel.setDateOfMarriage(ev.getDateOfMarriage());
					generalPanel.setDescription(ev.getGeneralDescription());
					
					husbandPanel.setFirstName(ev.getHusbandFirstName());
					husbandPanel.setMiddleName(ev.getHusbandMiddleName());
					husbandPanel.setLastName(ev.getHusbandLastName());
					husbandPanel.setDateOfBirth(ev.getHusbandBirthDate());
					husbandPanel.setAgeCountTextField(ev.getHusbandBirthDate());
					
					wifePanel.setFirstName(ev.getWifeFirstName());
					wifePanel.setMiddleName(ev.getWifeMiddleName());
					wifePanel.setLastName(ev.getWifeLastName());
					wifePanel.setDateOfBirth(ev.getWifeBirthDate());
					wifePanel.setAgeCountTextField(ev.getWifeBirthDate());
				}	
				
			}
			
		});
	}
	
	public void disableAllFields(){
		toolBar.getSaveBtn().setEnabled(false);
		tabPane.setEnabled(false);
		generalPanel.disableAllFields();
	}
	
	public void enableAllFields(){
		toolBar.getSaveBtn().setEnabled(true);
		tabPane.setEnabled(true);
		generalPanel.enableAllFields();
	}
	
	public void clearAllApplicationFields(){
		generalPanel.clearAllFields();
		husbandPanel.clearAllFields();
		wifePanel.clearAllFields();
	}
	
	public ToolBar getToolBar(){
		return toolBar;
	}

}
