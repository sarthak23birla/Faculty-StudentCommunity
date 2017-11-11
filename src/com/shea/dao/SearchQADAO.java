package com.shea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class SearchQADAO {
	
	static String provider="jdbc:mysql://localhost:3306/facultyandstudent";
	public static ResultSet Search(String sqa)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
		String query="select * from studentquestion,studentanswere  where question like '%"+sqa+"%'";
		
	ResultSet rs=DBHelper.executeQuery(cn, query); 
	System.out.println(query);
	return rs;

	}catch(Exception e)
	{ System.out.println(e);
		return null;
		}
		}


}
