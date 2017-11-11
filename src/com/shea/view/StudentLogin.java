package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentLogin
 */
@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLogin() {
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
		 
		 out.println("<form action=StudentChkPwd>");
		  out.println("<center>");
		  
		  out.println("<caption><center><h1><i><u>Student Login</u></i></h1></center></caption>");
		  out.println("<tr><td><b><i>Student Id:</i></b></td><td><input type=text   name=sid size=40 required='required'></br></td></tr>");
		  out.println("<tr><td><b><i>Password:</i></b></td><td><input type=password  name=pwd size=40 required='required'></br></td></tr>");
		  out.println("<tr><td><input type=submit value=LogIn></td><td>&nbsp;</td></tr>");
	      out.println("</center></form></html>");
	      out.flush();
	}
	

}
