package ua.fesvlast.tim.gui.utils.listeners;

import java.util.EventListener;

public interface IEditChildListener extends EventListener{
	
	public void rowEdited(int row, ChildEvent ev);
}
