package ua.fesvlast.tim;

import javax.swing.SwingUtilities;

import ua.fesvlast.tim.gui.MainFrame;


public class Runner {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new  Runnable() {
			@Override
			public void run() {
				new MainFrame();	
			}
			/* Comment*/
		});

	}

}
