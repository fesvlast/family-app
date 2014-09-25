package ua.fesvlast.tim.gui.childGui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JToolBar;
import javax.swing.border.Border;

import ua.fesvlast.tim.gui.MainFrame;
import ua.fesvlast.tim.gui.dialogs.ChildDialog;
import ua.fesvlast.tim.gui.utils.FamilyFileFilter;

public class ChildToolBar extends JToolBar{
	private JButton createRow;
	private JButton editRow;
	private JButton removeRow;
	
	
	
	public ChildToolBar(){
	
		Border innerBorder =BorderFactory.createEtchedBorder();
		Border outerBorder =BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		//this.setBorder(BorderFactory.createEtchedBorder());
		
		
		createRow =new JButton();
		createRow.setIcon(createIcon("/images/Add16.gif"));
		editRow =new JButton();
		editRow.setIcon(createIcon("/images/RowInsertBefore16.gif"));
		removeRow =new JButton();
		removeRow.setIcon(createIcon("/images/RowDelete16.gif"));
		
		createRow.setToolTipText("Add new child.");
		editRow.setToolTipText("Edit child's row.");
		removeRow.setToolTipText("Remove child's row.");
			
		add(createRow);
		add(editRow);
		add(removeRow);
		
			
	}		
		

	
	private ImageIcon createIcon (String path){
		URL url =	getClass().getResource(path);
		if(url==null){
			System.err.println("Unable to load image: "+path);
		}
		ImageIcon icon =new ImageIcon(url);
		return icon;	
	}
	
	
	public JButton getCreateRowButton(){
		return createRow;
	}
	
	public JButton getEditRowButton(){
		return editRow;
	}
	public JButton getRemoveRowButton(){
		return removeRow;
	}
	

}
