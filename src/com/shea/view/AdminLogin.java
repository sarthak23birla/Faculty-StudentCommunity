package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		  out.println("<form action=AdminChkPwd>");
	      out.println("<a href=Home>Home</a>");
	      out.println("<center><table>");
		  out.println("<caption><h2><i>Administrator Login</i></h2></caption>");
		  out.println("<tr><td><b><i>Admin Id:</i></b></td><td><input type=text   name=aid size=40 required='required'></br></td></tr>");
		  out.println("<tr><td><b><i>Password:</i></b></td><td><input type=password  name=pwd size=40 required='required'></br></td></tr>");
		  out.println("<tr><td><input type=submit value=LogIn></td><td>&nbsp;</td></tr>");
	      out.println("</table></center></form></html>");
	      out.flush();

			  


	}

}
