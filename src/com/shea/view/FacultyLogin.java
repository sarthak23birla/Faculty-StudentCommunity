package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FacultyLogin
 */
@WebServlet("/FacultyLogin")
public class FacultyLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		 out.println("<form action=FacultyChkPwd>");
		  out.println("<center><table>");
		  out.println("<caption><h2><i>Faculty Login</i></h2></caption>");
		  out.println("<tr><td><b><i>Faculty Id:</i></b></td><td><input type=text   name=fid size=40 required='required'></br></td></tr>");
		  out.println("<tr><td><b><i>Password:</i></b></td><td><input type=password  name=pwd size=40 required='required'></br></td></tr>");
		  out.println("<tr><td><input type=submit value=LogIn></td><td>&nbsp;</td></tr>");
	      out.println("</table></center></form></html>");
	      out.flush();

	
	}

}
