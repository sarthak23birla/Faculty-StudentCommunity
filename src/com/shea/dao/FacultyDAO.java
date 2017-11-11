package com.shea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.shea.model.Faculty;




public class FacultyDAO {
	static String provider="jdbc:mysql://localhost:3306/facultyandstudent";
	
	public static Faculty chkPassword(String fid,String fpass )
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select * from faculty where facultyid='"+fid+"' and password='"+fpass+"'";
	
	ResultSet rs=DBHelper.executeQuery(cn, query); 
   if(rs.next())
   {
     Faculty F=new Faculty();
     F.setFacultyid(rs.getString(1));
     F.setFacultyname(rs.getString(2));
     F.setPassword(rs.getString(11));
     return F;
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

	
	

	
	public static boolean addNewRecord(Faculty F)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="insert into faculty values('"+F.getFacultyid()+"','"+F.getFacultyname()+"','"+F.getDob()+"','"+F.getGender()+"','"+F.getAddress()+"','"+F.getContactno()+"','"+F.getEmailid()+"','"+F.getQualifaction()+"','"+F.getBranch()+"','"+F.getPhotograph()+"','"+F.getPassword()+"')";
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
	String query="select * from faculty";
	ResultSet rs=DBHelper.executeQuery(cn, query); 

	return rs;

	}catch(Exception e)
	{ System.out.println(e);
		return null;
		}
	}
	
	
	public static ResultSet DisplayByBranch(String bid)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select * from faculty where branch='"+bid+"'";
	ResultSet rs=DBHelper.executeQuery(cn, query); 

	return rs;

	}catch(Exception e)
	{ System.out.println(e);
		return null;
		}
	}

	
	public static ResultSet DisplayById(String fid)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
	Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select * from faculty where facultyid='"+fid+"'";
	ResultSet rs=DBHelper.executeQuery(cn, query); 

	return rs;

	}catch(Exception e)
	{ System.out.println(e);
	return null;
	}}
	
	public static boolean EditRecord(Faculty F)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="update faculty set facultyname='"+F.getFacultyname()+"',birthdate='"+F.getDob()+"',gender='"+F.getGender()+"',address='"+F.getAddress()+"',contactno='"+F.getContactno()+"',Emailid='"+F.getEmailid()+"',Qualifaction='"+F.getQualifaction()+"',Branch='"+F.getBranch()+"' ,photograph='"+F.getPhotograph()+"'where facultyid='"+F.getFacultyid()+"'";
	System.out.println(query);
	boolean st=DBHelper.executeUpdate(cn, query);
	return st;

	}catch(Exception e)
	{ System.out.println(e);
		return false;
		}
	}

	public static boolean DeleteById(String fid)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
	Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="delete from faculty where facultyid='"+fid+"'";
	 boolean st=DBHelper.executeUpdate(cn, query);
	 return st;
	}catch(Exception e)
	{ System.out.println(e);
	return false;
	}}
	
	
	public static int getID()
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select max(facultyid) from faculty";
	ResultSet rs=DBHelper.executeQuery(cn, query);
	int id=0;
	if(rs.next())
	{  id=rs.getInt(1);
	  if(id==0)
	  {id=999;}
	}
	return(id+1); 

	}catch(Exception e)
	{ System.out.println(e);
		return -1;
		}}
	
	public static ResultSet DisplaySelectedRecord(String fid)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
		Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select * from faculty where facultyid='"+fid+"'";
	ResultSet rs=DBHelper.executeQuery(cn, query); 

	return rs;

	}catch(Exception e)
	{ System.out.println(e);
		return null;
		}
	}

}
