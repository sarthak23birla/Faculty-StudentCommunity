package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shea.dao.StudentDAO;

/**
 * Servlet implementation class StudentInterface
 */
@WebServlet("/StudentInterface")
public class StudentInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInterface() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  PrintWriter out=response.getWriter();
		  out.println("<script src=asset/jquery-2.2.1.min.js></script>");
		  out.println("<script src=fills.js /></script>"); 
		  out.println("<html>");
		  out.println("<a href=StudentDisplayAll>List of Students</a>");
		  out.println("<form action=StudentSubmit method=post enctype=\"multipart/form-data\">");
		  int id=StudentDAO.getID();
		  out.println("<center><table>");
		  out.println("<caption><h2><i>Student Registration</i></h2></caption>");
		  out.println("<tr><td><b><i>Student Id:</i></b></td><td><input  readonly type=text   name=sid size=40 value="+id+" required='required'></br></td></tr>");
		  out.println("<tr><td><b><i>Student Name:</i></b></td><td><input type=text   name=sn size=40 required='required'></br></td></tr>");
		  out.println("<tr><td><b><i>Gender:</i></b></td><td><input type=radio name=sg value=Male>Male<input type=radio name=sg value=Female>Female</td></tr>");
		  out.println("<tr><td><b><i>Email:</i></b></td><td><input type=text placeholder='Ex:saxena.sakshi@gmail.com'  name=se size=40 required='required'></br></td></tr>");
		  out.println("<tr><td><b><i>Branch:</i></b></td><td><select name='sb'   id='sb' ><option value=''>Select branch</option></select></br></td></tr>");
		  out.println("<tr><td><b><i>year:</i></b></td><td><input type=text   name=sy size=40 required='required'></br></td></tr>");
          out.println("<tr><td><b><i>Semester:</i></b></td><td><select name='ss'   id='ss' ><option value=''>Select semester</option></select></br></td></tr>");
		  out.println("<tr><td><b><i>Subject:</i></b></td><td><select name='sub'   id='sub' ><option value=''>Select subject</option></select></br></td></tr>");
          out.println("<tr><td><b><i>Contact No:</i></b></td><td><input type=text name=sc size=40></td></tr>");
		  out.println("<tr><td><b><i>Father Contact No:</i></b></td><td><input type=text name=sf size=40></td></tr>");
		  out.println("<tr><td><b><i>Birth Date</i></b></td><td><input type=date name=sd size=40></td></tr>");
		  out.println("<tr><td><b><i>Address:</i></b></td><td><textarea name=sa rows=3 cols=30></textarea></td></tr>");
		  out.println("<tr><td><b><i>Photograph:</i></b></td><td><input type=file name=sp size=40></td></tr>");
		  out.println("<tr><td><b><i>Password:</i></b></td><td><input type=password name=spass size=40></td></tr>");
		  out.println("<tr><td><input type=submit   value=Submit></td><td><input type=reset></td></tr>");
		  out.println("</table></center></form></html>");
		  out.flush();
		          
	}

	}


	



