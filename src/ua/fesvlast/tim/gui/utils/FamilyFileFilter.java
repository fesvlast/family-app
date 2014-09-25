package ua.fesvlast.tim.gui.utils;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FamilyFileFilter extends FileFilter{

	@Override
	public boolean accept(File file) {
		
		if(file.isDirectory()){
			return true;
		}
		
		String name =file.getName();
		
		String extention =Utils.getFileExtention(name);
		
		if(extention ==null){
			return false;
		}
		
		if(extention.equals("cds")){
			return true;
		}
		
		return false;
	}

	@Override
	public String getDescription() {
		
		return "Family database files (*.cds)";
	}

}
