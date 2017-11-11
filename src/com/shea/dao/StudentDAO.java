package com.shea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.shea.model.Student;


public class StudentDAO {
	static String provider="jdbc:mysql://localhost:3306/facultyandstudent";
	public static boolean addNewRecord(Student S)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
		
		String query="insert into student values('"+S.getStudentid()+"','"+S.getStudentname()+"','"+S.getGender()+"','"+S.getEmailid()+"','"+S.getBranch()+"','"+S.getYear()+"','"+S.getSemester()+"','"+S.getContactno()+"','"+S.getFcontactno()+"','"+S.getDob()+"','"+S.getAddress()+"','"+S.getPhotograph()+"','"+S.getPassword()+"')";
	System.out.println(query);
	boolean st=DBHelper.executeUpdate(cn, query);
	return st;

	}catch(Exception e)
	{ System.out.println(e);
		return false;
	}}
	public static Student chkPassword(String sid,String spass )
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select * from student where studentid='"+sid+"' and password='"+spass+"'";
	
	ResultSet rs=DBHelper.executeQuery(cn, query); 
   if(rs.next())
   {
     Student S=new Student();
     S.setStudentid(rs.getString(1));
     S.setBranch(rs.getString(5));
     S.setStudentname(rs.getString(2));
     return S;
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
	
	public static int getID()
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select max(studentid) from student";
	ResultSet rs=DBHelper.executeQuery(cn, query);
	int id=0;
	if(rs.next())
	{  id=rs.getInt(1);
	  if(id==0)
	  {id=99;}
	}
	return(id+1); 

	}catch(Exception e)
	{ System.out.println(e);
		return -1;
		}
	}

	public static ResultSet DisplayAllRecord()
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="SELECT s.*,b.branchname FROM branch b,student s where b.branchid=s.branch";
	ResultSet rs=DBHelper.executeQuery(cn, query); 

	return rs;

	}catch(Exception e)
	{ System.out.println(e);
		return null;
		}
	}
	
	

	public static ResultSet DisplayById(String sid)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
	Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select * from student where studentid='"+sid+"'";
	ResultSet rs=DBHelper.executeQuery(cn, query); 

	return rs;

	}catch(Exception e)
	{ System.out.println(e);
	return null;
	}}
	

	public static boolean EditRecord(Student S)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
		String query="";
		if(S.getPhotograph().equals(null)||S.getPhotograph().equals("")){
			 query="update student set studentname='"+S.getStudentname()+"',gender='"+S.getGender()+"',Emailid='"+S.getEmailid()+"',Branch='"+S.getBranch()+"',year='"+S.getYear()+"',Semester='"+S.getSemester()+"',contactno='"+S.getContactno()+"' ,fcontactno='"+S.getFcontactno()+"',dob='"+S.getDob()+"',address='"+S.getAddress()+"' where studentid='"+S.getStudentid()+"'";

		}
		else{
			query="update student set studentname='"+S.getStudentname()+"',gender='"+S.getGender()+"',Emailid='"+S.getEmailid()+"',Branch='"+S.getBranch()+"',year='"+S.getYear()+"',Semester='"+S.getSemester()+"',contactno='"+S.getContactno()+"' ,fcontactno='"+S.getFcontactno()+"',dob='"+S.getDob()+"',address='"+S.getAddress()+"',photograph='"+S.getPhotograph()+"' where studentid='"+S.getStudentid()+"'";
			
		}
	System.out.println(query);
	boolean st=DBHelper.executeUpdate(cn, query);
	return st;

	}catch(Exception e)
	{ System.out.println(e);
		return false;
		}
	}

	public static boolean DeleteById(String sid)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
	Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="delete from student where studentid='"+sid+"'";
	 boolean st=DBHelper.executeUpdate(cn, query);
	 return st;
	}catch(Exception e)
	{ System.out.println(e);
	return false;
	}}
	
	public static ResultSet DisplaySelectedRecord(String sid)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select * from student where studentid='"+sid+"'";
	ResultSet rs=DBHelper.executeQuery(cn, query); 

	return rs;

	}catch(Exception e)
	{ System.out.println(e);
		return null;
		}
	}}

