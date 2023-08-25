package Generic_Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBUtilities implements IAutoConstant {
	public Connection connection;
	public Statement statement;
	public ResultSet values;
	public  void connectionToDataBase()
	{
		 try {
			connection=DriverManager.getConnection(JDBC_URL, JDBC_UN, JDBC_PW);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public List<readdatafromconstructor> readingTheDataFromDatabase(String query)
	{
		List<readdatafromconstructor> data = new ArrayList<>();
		
		try {
			 statement=connection.createStatement();
				 values=statement.executeQuery(query);
			 
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		try {
			while(values.next()) {
				String id=values.getString("id");
				String emp_name=values.getString("emp_name");
				String emp_address=values.getString("emp_address");
				String phone_no=values.getString("phone_no");
				readdatafromconstructor record = new readdatafromconstructor(id, emp_name, emp_address, phone_no);
				data.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	
	}
	
	public void closeTheConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
