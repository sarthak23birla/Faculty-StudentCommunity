package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shea.dao.AnswereDAO;

/**
 * Servlet implementation class DisplayShareRecord
 */
@WebServlet("/DisplayShareRecord")
public class DisplayShareRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayShareRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
	      try{
	       out.println("<html>");
	       
	       //out.println("<a href=>Add New Record</a>");
	       ResultSet rs=AnswereDAO.DisplayShareRecord("s");	       
	       if(rs.next())
	       {
	       out.println("<table border=2>");
	       out.println("<caption><b><i>view all questions and answer</i></b></caption>");
	       out.println("<tr><th>Question</th><th>Answer</th></tr>");
	       do
	       {out.println("<tr><td>"+rs.getString(12)+"</td><td>"+rs.getString(4)+"</td></tr>");
	    	  
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
