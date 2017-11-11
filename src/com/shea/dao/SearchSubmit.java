package com.shea.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchSubmit
 */
@WebServlet("/SearchSubmit")
public class SearchSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
	try
	{
		
		String sqa=request.getParameter("sqa");
		System.out.println(sqa);
		ResultSet rs=SearchQADAO.Search(sqa);
		if(rs.next())
		{System.out.println("hello");
			 out.println("<html><center>");
	    out.println("<table border=1>");
			 out.println("<tr><th>studentid</th><th>Question</th></tr>");
	       do
	       {
	    	   
	    	   out.println("<tr><td>"+rs.getString(5)+"</td><td>"+rs.getString(9)+"</td></tr>");
	    	  
	       }while(rs.next());
	       out.println("</table>");
	       }
	       else
	       {
	    	 out.println("<b><i>Record Not Found</i></b>");  
	       }
	
	}catch(Exception ee)
	{
		
	}
		
	}

}
