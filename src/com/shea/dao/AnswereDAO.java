package com.shea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.shea.model.Answere;

public class AnswereDAO {
		
		static String provider="jdbc:mysql://localhost:3306/facultyandstudent";

	public static boolean addNewRecord(Answere A)
	{try
	{
	Class.forName("com.mysql.jdbc.Driver").newInstance();   
	Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="insert into studentanswere (questionid,Facultyid,Date,Answere,studentid,status) values('"+A.getQuestionid()+"','"+A.getFacultyid()+"','"+A.getDate()+"','"+A.getAnswere()+"','"+A.getStudentid()+"','"+A.getStatus()+"')";
	System.out.println(query);
	boolean st=DBHelper.executeUpdate(cn, query);
	return st;

	}catch(Exception e)
	{ System.out.println(e);
		return false;
		}}
	
	
	public static ResultSet DisplayShareRecord(String s)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
		String query="select s.*,sq.* from studentanswere s,studentquestion sq  where s.status='Share' and sq.questionid=s.questionid";
		
	ResultSet rs=DBHelper.executeQuery(cn, query); 

	return rs;

	}catch(Exception e)
	{ System.out.println(e);
		return null;
		}
		}

	public static ResultSet DisplayAnswer(String sid)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
		//String query="select s.*,sq.* from studentanswere s,studentquestion sq  where and sq.facultyid=s.facultyid and fsq.studentid='"+sid+"' and s.studentid='"+sid+"'";
		String query="select s.*,sq.* from studentanswere s,studentquestion sq  where sq.studentid=s.studentid and sq.facultyid=s.facultyid and sq.questionid=s.questionid and sq.studentid='"+sid+"'";
	ResultSet rs=DBHelper.executeQuery(cn, query); 

	return rs;

	}catch(Exception e)
	{ System.out.println(e);
		return null;
		}



	}

}

