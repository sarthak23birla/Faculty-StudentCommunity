package com.shea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.shea.model.Question;

public class QuestionDAO {
	static String provider="jdbc:mysql://localhost:3306/facultyandstudent";
	
	public static boolean addNewRecord(Question q)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
	Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="insert into studentquestion(Studentid,Facultyid,Date,Question) values('"+q.getStudentid()+"','"+q.getFacultyid()+"','"+q.getDate()+"','"+q.getQuestion()+"')";
	System.out.println(query);
	boolean st=DBHelper.executeUpdate(cn, query);
	return st;

	}catch(Exception e)
	{ System.out.println(e);
		return false;
		}

	
	
	}
	
	public static ResultSet DisplayAllRecord()
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select * from studentquestion";
	ResultSet rs=DBHelper.executeQuery(cn, query); 

	return rs;

	}catch(Exception e)
	{ System.out.println(e);
		return null;
		}
	}
	public static ResultSet DisplaySelectedRecord(String fid)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select * from studentquestion where facultyid='"+fid+"'";
	ResultSet rs=DBHelper.executeQuery(cn, query); 

	return rs;

	}catch(Exception e)
	{ System.out.println(e);
		return null;
		}

	}
	

	
	public static ResultSet DisplayStudentQuestion(String fid)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select s.*,sq.* from faculty s,studentquestion sq  where sq.facultyid=s.facultyid and s.facultyid='"+fid+"'";
	ResultSet rs=DBHelper.executeQuery(cn, query); 
	System.out.println(query);
	return rs;

	}catch(Exception e)
	{ System.out.println(e);
		return null;
		}

	}
}
