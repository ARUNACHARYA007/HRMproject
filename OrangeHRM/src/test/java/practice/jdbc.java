package practice;

import java.util.List;

import Generic_Utility.JDBUtilities;
import Generic_Utility.readdatafromconstructor;

public class jdbc {
	public static void main(String[] args) {
		
	 JDBUtilities util=new JDBUtilities();

	
		util.connectionToDataBase();
		
		List<readdatafromconstructor> store = util.readingTheDataFromDatabase("select * from employee");
	   
		for (readdatafromconstructor data : store) {
		System.out.println(data);
		
	   }
		
		
	util.closeTheConnection();
	}

}
