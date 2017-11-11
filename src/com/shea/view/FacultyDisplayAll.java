package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shea.dao.FacultyDAO;



/**
 * Servlet implementation class FacultyDisplayAll
 */
@WebServlet("/FacultyDisplayAll")
public class FacultyDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyDisplayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
	      try{
	       out.println("<html>");
	       
	       out.println("<a href=FacultyInterface>Add New Record</a>");
	       ResultSet rs=FacultyDAO.DisplayAllRecord();
	       
	       if(rs.next())
	       {
	       out.println("<table border=1>");
	       out.println("<caption><b><i>List of Faculties</i></b></caption>");
	       out.println("<tr><th>Faculty Id</th><th>Name</th><th>DOB</th><th>Gender</th><th>Address</th><th>Contact</th><th>Emailid</th><th>Qualifaction</th><th>Branch</th><th>Photograph</th><th>Update/Delete</th></tr>");
	       do
	       {out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td><img src=fpic/"+rs.getString(10)+" width=40 height=40></td><td><a href=FacultyEditDelete?fid="+rs.getString(1)+">Edit/Delete</a></tr>");
	    	  
	       }while(rs.next());
	       out.println("</table>");
	       }
	       else
	       {
	    	 out.println("<b><i>Record Not Found</i></b>");  
	       }
	       out.println("</html>");
	       out.flush();
	      }catch(Exception e){}
		

	
	}

}
