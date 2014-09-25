package ua.fesvlast.tim.gui.utils;

import java.util.Date;

public class WorkDate {
	
	public static int countYers(Date selectedDate){
		
		Date currentDate =new Date();
		int currentYear=currentDate.getYear();
		int selectedYear =selectedDate.getYear();
		
		int result =currentYear -selectedYear;
		
		if(result<0){
			result=0;
		}
		
		return result;
	}

}
