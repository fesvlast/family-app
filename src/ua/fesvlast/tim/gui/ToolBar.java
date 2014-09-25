package ua.fesvlast.tim.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import ua.fesvlast.tim.gui.utils.listeners.AllInformationEvent;
import ua.fesvlast.tim.gui.utils.listeners.IAddAllInformationListener;
import ua.fesvlast.tim.gui.utils.listeners.ILoadAllInformationListener;

public class ToolBar extends JToolBar{
	
	private JButton openBtn;
	private JButton saveBtn;
	private JButton newBtn;
	
	private IAddAllInformationListener addAllInformationListener;
	private ILoadAllInformationListener openAllInformationListener;
	
	
	
	
	public ToolBar(final MainFrame mainFrame){
		
		setBorder(BorderFactory.createEtchedBorder());

		
		openBtn =new JButton();
		openBtn.setIcon(createIcon("/images/Open24.gif"));
		saveBtn =new JButton();
		saveBtn.setIcon(createIcon("/images/Save24.gif"));
		newBtn =new JButton();
		newBtn.setIcon(createIcon("/images/New24.gif"));
		
		openBtn.setToolTipText("Open file that was save before.");
		saveBtn.setToolTipText("Save information into the file.");
		newBtn.setToolTipText("Create new file.");
		
		add(newBtn);
		add(openBtn);
		add(saveBtn);
		
		saveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(addAllInformationListener !=null){
					
					addAllInformationListener.getAllInformation();
				}
			}
		});
		
		openBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(openAllInformationListener !=null){
					openAllInformationListener.loadAllInformation();
				}
				
			}
		});
	
	}
	

	
	public JButton getOpenBtn(){
		return openBtn;
	}
	
	public JButton getSaveBtn(){
		return saveBtn;
	}
	
	public JButton getNewBtn(){
		return newBtn;
	}
	
	
	
	
	private ImageIcon createIcon (String path){
		URL url =	getClass().getResource(path);
		if(url==null){
			System.err.println("Unable to load image: "+path);
		}
		ImageIcon icon =new ImageIcon(url);
		return icon;	
	}
	public void setAllInformationListener(IAddAllInformationListener listener) {
		this.addAllInformationListener=listener;
	}



	public void setAllOpenInformationListener(ILoadAllInformationListener listener) {
		this.openAllInformationListener =listener;
		
	}



}
