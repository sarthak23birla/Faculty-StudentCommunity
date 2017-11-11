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
 * Servlet implementation class StudentHome
 */
@WebServlet("/StudentHome")
public class StudentHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentHome() {
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
		 { String nav="<h4><font color=green>Student:"+ses.getValue("SID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("SNAME").toString()+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LDATE").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a></h4><hr>";
		 out.println(nav);
		 out.println("<table>");
		 out.println("<tr>");
		 out.println("<td valign=top><a href=StudentInterface target=mw>Student Register</a><br>");
		 out.println("<a href=StudentLogout target=mw>Logout</a><br>");
		  out.println("</td>");
		 out.println("<td><iframe width=800 height=800 name=mw frameborder=0></iframe></td>");
		 out.println("</tr>");
		 out.println("</table>");
		 
		 
		 
		 
		
		 }catch(Exception e){
		  response.sendRedirect("AdminLogin");	 
			 
		 }
		 out.println("</html>");
	}

}




