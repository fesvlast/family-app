package ua.fesvlast.tim.model;

import java.io.File;

public class FileFormatter {
	
	public static File formatFile(File file) throws ClassNotFoundException{
		
		if(!file.exists()){
			throw new ClassNotFoundException();
		}
		String path =file.getPath();
		String name =file.getName();
		String dir=file.getParent();
	
		if(path.toLowerCase().contains(".cds")){
			return file;
		}else{
			path=dir+"/"+name+".cds";
			File newFile =new File(path);
			return newFile;
		}

	}

}
