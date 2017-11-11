package com.shea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.shea.model.fileupload;

public class FileUploadDAO {
		static String provider="jdbc:mysql://localhost:3306/facultyandstudent";
		public static boolean addNewRecord(fileupload F)
		{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
			Connection cn=DriverManager.getConnection(provider,"root","123");
			
			String query="insert into fileupload(facultyid,filename,filetype,date,fileURL)  values('"+F.getFacultyid()+"','"+F.getFilename()+"','"+F.getFiletype()+"','"+F.getDate()+"','"+F.getFileURL()+"')";
		System.out.println(query);
		boolean st=DBHelper.executeUpdate(cn, query);
		return st;

		}catch(Exception e)
		{ System.out.println(e);
			return false;
		}}

		public static ResultSet DisplayAllFile()
		{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();   
			Connection cn=DriverManager.getConnection(provider,"root","123");
		String query="select * from fileupload";
		ResultSet rs=DBHelper.executeQuery(cn, query); 

		return rs;

		}catch(Exception e)
		{ System.out.println(e);
			return null;
			}
		}

}
