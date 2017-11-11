package com.shea.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.shea.model.Trancction;




public class TransctionDAO {
	static String provider="jdbc:mysql://localhost:3306/facultyandstudent";
	public static boolean addNewRecord(Trancction T)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
	String q="insert into transaction(facultyid,branchid,semno,subjectid)values ('"+T.getFacultyid()+"','"+T.getBranchid()+"','"+T.getSemno()+"','"+T.getSubjectid()+"')";
		System.out.println(q);
		boolean st=DBHelper.executeUpdate(cn, q);
		return st;

		}catch(Exception e)
		{ System.out.println(e);
			return false;
			}
		}
		

}
