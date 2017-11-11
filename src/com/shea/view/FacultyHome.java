package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FacultyHome
 */
@WebServlet("/FacultyHome")
public class FacultyHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out=response.getWriter();
		 HttpSession ses=request.getSession(false);
		 out.println("<html>");
		 try
		 {String nav="<h4><font color=green>Admin:"+ses.getValue("FID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("FNAME").toString()+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LDATE").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a></h4><hr>";
		 out.println(nav);
		 out.println("<table>");
		 out.println("<tr>");
		 
		 out.println("<a href=FacultyInterface target=mw>Faculty Register</a><br>");
		 
		 out.println("<a href=FacultyLogout target=mw>Logout</a><br>");
		  out.println("</td>");
		 out.println("<td><iframe width=800 height=800 name=mw frameborder=0></iframe></td>");
		 out.println("</tr>");
		 out.println("</table>");
		 
		 
		 
		 
		
		 }catch(Exception e){
			 System.out.println(e);
		  response.sendRedirect("FacultyLogin");	 
			 
		 }
		 out.println("</html>");
	}
	}

