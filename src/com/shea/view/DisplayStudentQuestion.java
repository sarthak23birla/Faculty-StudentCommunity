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

import com.shea.dao.FacultyDAO;
import com.shea.dao.QuestionDAO;

/**
 * Servlet implementation class DisplayStudentQuestion
 */
@WebServlet("/DisplayStudentQuestion")
public class DisplayStudentQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayStudentQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   System.out.println("Hy");
		PrintWriter out=response.getWriter();
	      try{
	    	   System.out.println("Hello..");
	    	  
	    	  HttpSession ses=request.getSession();
			String fid=ses.getValue("FID").toString();
		  	   System.out.println(fid);
	       out.println("<html>");
	      
	      // out.println("<a href=FacultyInterface>Add New Record</a>");
	      ResultSet rs=QuestionDAO.DisplayStudentQuestion(fid);
	       
	      
	       if(rs.next())
	       {
	    	   System.out.println("Hello..");
	    	   
	       out.println("<table border=1>");
	       out.println("<caption><b><i>List of Question</i></b></caption>");
	       //out.println("<tr></tr>");
	       do
	       {out.println("<tr><td>"+rs.getString(16)+"</td><td>"+rs.getString(15)+"</td></tr>");
	    	  
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

