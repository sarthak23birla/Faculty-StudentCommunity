package com.shea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.shea.model.Admin;


public class AdminDAO {
	static String provider="jdbc:mysql://localhost:3306/facultyandstudent";
	public static Admin chkPassword(String aid,String pwd )
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select * from admin where adminid='"+aid+"' and password='"+pwd+"'";
	
	ResultSet rs=DBHelper.executeQuery(cn, query); 
   if(rs.next())
   {
     Admin A=new Admin();
     A.setAdminid(rs.getString(1));
     A.setAdminname(rs.getString(2));
     return A;
   }
   else
   {
	   return null;
   }

	}catch(Exception e)
	{ System.out.println(e);
		return null;
		}
	}

	
	
}
