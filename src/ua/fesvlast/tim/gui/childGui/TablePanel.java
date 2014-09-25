package ua.fesvlast.tim.gui.childGui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

import ua.fesvlast.tim.controller.Controller;
import ua.fesvlast.tim.gui.MainFrame;
import ua.fesvlast.tim.gui.utils.DontChooseRowException;
import ua.fesvlast.tim.gui.utils.listeners.IChildrenListener;
import ua.fesvlast.tim.gui.utils.listeners.IRemoveAllChildrenListener;
import ua.fesvlast.tim.model.beans.Child;

public class TablePanel extends JPanel {
	
	private JTable table;
	private ChildTableModel model;
	private ChildToolBar bar;
	
	private IChildrenListener childRemoveListener;
	private IRemoveAllChildrenListener removeAllChildrenListener;
	
	public TablePanel(final MainFrame frame){
		
		Border innerBorder =BorderFactory.createEtchedBorder();
		Border outerBorder =BorderFactory.createEmptyBorder(0,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		bar=new ChildToolBar();
		model =new ChildTableModel();
		table =new JTable(model);

		
		setLayout(new BorderLayout());
		add(bar, BorderLayout.NORTH);
		add(new JScrollPane(table),BorderLayout.CENTER);
		
	
		bar.getRemoveRowButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				try{
					if(row==-1){
						throw new DontChooseRowException();
					}
					childRemoveListener.rowDeleted(row);
					model.fireTableRowsDeleted(row, row);
				}catch(DontChooseRowException ex){
					JOptionPane.showMessageDialog(frame, "Select the row, please.", "Delete row message", JOptionPane.INFORMATION_MESSAGE);
				}		
			}
		});
		
		frame.getToolBar().getNewBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 int totalRows =table.getRowCount();	 
				if(removeAllChildrenListener !=null){
					removeAllChildrenListener.removeAllChildren();
					model.fireTableRowsDeleted(0, totalRows);
				}
			}
		});
		
	}
	
	
	public void setData(List<Child> ds){
		model.setData(ds);
	}
	
	public ChildToolBar getBar(){
		return bar;
	}
	
	public JTable getChildTable(){
		return table;
	}

	public void refresh() {
		model.fireTableDataChanged();

	}
	
	public void setChildrenTableListener(IChildrenListener listener){
		this.childRemoveListener =listener;
	}


	public void setRemoveAllChildrenListener(IRemoveAllChildrenListener listener) {	
		this.removeAllChildrenListener =listener;	
	}

}
