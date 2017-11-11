package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shea.dao.AnswereDAO;
import com.shea.dao.QuestionDAO;

/**
 * Servlet implementation class DispalyAnswer
 */
@WebServlet("/DispalyAnswer")
public class DispalyAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispalyAnswer() {
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
	    	   
	    	  HttpSession ses=request.getSession();
			String sid=ses.getValue("SID").toString();
	       out.println("<html>");
	      
	      // out.println("<a href=FacultyInterface>Add New Record</a>");
	      ResultSet rs=AnswereDAO.DisplayAnswer(sid);
	       
	      
	       if(rs.next())
	       {
	    	   	    	   
	       out.println("<table border=1>");
	       out.println("<caption><b><i>List of Question</i></b></caption>");
	       //out.println("<tr></tr>");
	       do
	       {out.println("<tr><td>"+rs.getString(12)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(3)+"</td></tr>");
	    	  
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

