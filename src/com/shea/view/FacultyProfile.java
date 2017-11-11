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
import com.shea.dao.StudentDAO;

/**
 * Servlet implementation class FacultyProfile
 */
@WebServlet("/FacultyProfile")
public class FacultyProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyProfile() {
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
	    	  HttpSession ses=request.getSession(false);
	    	  String fid=   ses.getValue("FID").toString();
	       out.println("<html>");
	       
	      // out.println("<a href=FacultyInterface></a>");
	        out.println("<a href=Home>logout<br></a>");
	        

	       ResultSet rs=FacultyDAO.DisplaySelectedRecord(fid);	       
	       if(rs.next())
	       {
	       out.println("<table border=0>");
	       out.println("<caption><b><i>faculty Profile</i></b></caption>");
	    
	       do
	       {
	    	   out.println("<tr><td><img src=fpic/"+rs.getString(10)+" width=140 height=140></td><td><br>"+rs.getString(1)+"</td><td><br><br>"+rs.getString(2)+"</td></tr>");
	   
	    	   
	 		out.println("<a href=ViewAllQuestion target=st>Dispaly Students Questions</a><br>");

	       }while(rs.next());
	       out.println("</table>");
	       out.println("<center><iframe   width=2000 height=500 frame border=1 scrolling=auto name=st ></iframe></center>");
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
