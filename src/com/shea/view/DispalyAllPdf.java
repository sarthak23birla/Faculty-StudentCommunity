package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shea.dao.FileUploadDAO;

/**
 * Servlet implementation class DispalyAllPdf
 */
@WebServlet("/DispalyAllPdf")
public class DispalyAllPdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispalyAllPdf() {
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
	       out.println("<html>  <link rel=\"stylesheet\" type=\"text/css\" href=\"asset/datatable/jquery.dataTables.css\">");
	       
	        ResultSet rs=FileUploadDAO.DisplayAllFile();
	       
	       if(rs.next())
	       {
	       out.println("<table class=\"table datatable\"><thead>");
	       //out.println("<caption><b><i>List of Faculties</i></b></caption>");
	       out.println("<tr><th>File Name</th><th>File Type</th><th>Date</th><th>Download</th></thead><tbody>");
	       do
	       {out.println("<tr><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td><a href=\"fload/"+rs.getString(6)+"\" download=\"fload/"+rs.getString(6)+"\">Download</a></td></tr>");
	    	  
	       }while(rs.next());
	       out.println("<tbody></table>");
	       }
	       else
	       {
	    	 out.println("<b><i>Record Not Found</i></b>");  
	       }
	       out.println("</html>");
	       out.println("  <script type=\"text/javascript\" charset=\"utf8\" src=\"asset/jquery-2.2.1.min.js\"></script>");
	       out.println("<script type=\"text/javascript\" charset=\"utf8\" src=\"asset/datatable/jquery.dataTables.min.js\"></script>");
	    		   out.println("<script>");
	    				   out.println(" $(function(){");
    out.println("$(\".datatable\").dataTable();");
  out.println("})");
  out.println("</script>");
	       out.flush();
	      }catch(Exception e){}
		

	
	}

}
