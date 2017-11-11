package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shea.dao.FacultyDAO;


/**
 * Servlet implementation class FacultyInterface
 */
@WebServlet("/FacultyInterface")
public class FacultyInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyInterface() {
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
		  out.println("<a href=FacultyDisplayAll>List of Faculties</a>");
		  out.println("<form action=FacultySubmit method=post enctype=\"multipart/form-data\">");
		  out.println("<table>");
		  out.println("<caption><h2><i>Faculty Registration</i></h2></caption>");
		  int id=FacultyDAO.getID();

		  out.println("<tr><td><b><i>Faculty Id:</i></b></td><td><input  readonly type=text   name=fid size=40 value="+id+" required='required'></br></td></tr>");
		  out.println("<tr><td><b><i>Name:</i></b></td><td><input type=text name=fn size=40 required='required'></td></tr>");
		  out.println("<tr><td><b><i>Birtth Date</i></b></td><td><input type=date name=fbd size=40 required='required'></td></tr>");
		  out.println("<tr><td><b><i>Gender:</i></b></td><td><input type=radio name=fg value=Male>Male<input type=radio name=fg value=Female>Female</td></tr>");
		  out.println("<tr><td><b><i>Address:</i></b></td><td><textarea name=fa rows=3 cols=30 required='required'></textarea></td></tr>");
		  out.println("<tr><td><b><i>Contact No:</i></b></td><td><input type=text name=fc size=40 required='required'></td></tr>");
		  out.println("<tr><td><b><i>Email Id:</i></b></td><td><input type=text name=fm size=40 required='required'></td></tr>");
          out.println("<tr><td><b><i>Qualifaction:</i></b></td><td><input type=text name=fq size=40 required='required'></td></tr>");
		  out.println("<tr><td><b><i>Branch:</i></b></td><td><select name='fb'   id='sb' ><option value=''>Select branch</option></select></br></td></tr>");
		  out.println("<tr><td><b><i>Photograph:</i></b></td><td><input type=file name=fp size=40 required='required'></td></tr>");
		  out.println("<tr><td><b><i>Password:</i></b></td><td><input type=password name=fpass size=40 required='required'></td></tr>");

		  out.println("<tr><td><input type=submit></td><td><input type=reset></td></tr>");
		  out.println("</table></form></html>");
		  out.flush();
		          
		}

	}


