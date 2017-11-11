package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shea.dao.StudentDAO;

/**
 * Servlet implementation class StudentDisplayAll
 */
@WebServlet("/StudentDisplayAll")
public class StudentDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDisplayAll() {
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
	       out.println("<head><link href='design/css/bootstrap.min.css' rel='stylesheet'></head>");
	       out.println("<a href=StudentInterface class='btn btn-danger'>Add New Record</a>");
	       ResultSet rs=StudentDAO.DisplayAllRecord();
	       
	       if(rs.next())
	       {
	       out.println("<table class='table table-bordered'><caption><b><i><h4>List of Student</h4></i></b></caption>");
	       out.println("<tr><th>Student Id</th><th>Name</th><th>Gender</th><th>Emailid</th><th>Branch</th><th>year</th><th>Semester</th><th>contactno</th><th>fcontactno</th><th>Birthdate</th><th>Address</th><th>photograph</th><th>Update/Delete</th></tr>");
	       do
	       {out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString("branchname")+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td><td><img src=spic/"+rs.getString(12)+" width=40 height=40></td><td><a href=StudentEditDelete?sid="+rs.getString(1)+" class='btn btn-warning'>Edit/Delete</a></tr>");
	    	  
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

	
	


