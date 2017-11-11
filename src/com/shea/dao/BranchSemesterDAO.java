package com.shea.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class BranchSemesterDAO {
	static String provider="jdbc:mysql://localhost:3306/facultyandstudent";
    public static ResultSet FetchBranch()
    {
    	try{ 
    			Class.forName("com.mysql.jdbc.Driver").newInstance();   
    			Connection cn=DriverManager.getConnection(provider,"root","123");
    			String query="Select * from branch";
    			ResultSet rs=DBHelper.executeQuery(cn, query);
    			return(rs);
    		}
    	catch(Exception e)
    		{
    			System.out.println("error"+e.getMessage());	
    			return null;
    		}
    }
    public static ResultSet FetchSemester(String sbid)
    {
    	try{ 
    			Class.forName("com.mysql.jdbc.Driver").newInstance();   
    			Connection cn=DriverManager.getConnection(provider,"root","123");
    			String query="Select * from semester where branchid='"+sbid+"'";
    			ResultSet rs=DBHelper.executeQuery(cn, query);
    			return(rs);
    		}
    	catch(Exception e)
    		{
    			System.out.println(e);	
    			return null;
    		}
    } 
    public static ResultSet FetchSubject(String ssid)
    {
    	try{ 
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
				Class.forName("com.mysql.jdbc.Driver").newInstance();   
				Connection cn=DriverManager.getConnection(provider,"root","123");
				String query="Select * from subject where semesterid='"+ssid+"'";
				ResultSet rs=DBHelper.executeQuery(cn, query);
				return(rs);
			}
    	catch(Exception e)
    		{
			     System.out.println(e);	
			     return null;
    		}
    } 
}
