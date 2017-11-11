package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shea.dao.SearchQADAO;
import com.shea.dao.StudentDAO;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		//HttpSession ses=request.getSession(false);
  	  //String sqa= ses.getValue("SQA").toString();

		  out.println("<script src=asset/jquery-2.2.1.min.js></script>");
		  out.println("<script src=fills.js /></script>"); 
		  out.println("<html>");
		  out.println("<form action=SearchSubmit >");
		  
		  out.println("<tr><td><b><i>Search:</i></b></td><td><input type=text   name=sqa size=100 required='required'></br></td></tr>");
		  out.println("<tr><td><input type=Submit   value=Submit></td><td><input type=reset></td></tr>");
		  out.println("</table></center></form></html>");
		  out.flush();
		          
	
	}

}
