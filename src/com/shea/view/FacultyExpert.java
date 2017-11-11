package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shea.dao.FacultyDAO;

/**
 * Servlet implementation class FacultyExpert
 */
@WebServlet("/FacultyExpert")
public class FacultyExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FacultyExpert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		try {
			 HttpSession ses=request.getSession(false);
			out.println("<html>");
			out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
			out.println("<script src='asset/bootstrap.min.js'></script>");
			out.println("<script src='asset/viewjs.js'></script>");
			
			out.println("<link href='asset/css/bootstrap.css' type='text/css' rel='stylesheet'>");
			out.println("<link href='asset/css/bootstrap-material-design.css' type='text/css' rel='stylesheet'>");

			String bid=ses.getValue("bid").toString();
		 // out.println("<a href=FacultyInterface>Add New Record</a>");
			ResultSet rs = FacultyDAO.DisplayByBranch(bid);
			int i=1;
			out.println("<center><h1><b><i><u>Experts Faculties</u></i></b></h1></center><table class='table experts'><tr>");
			
			if (rs.next()) {

				// out.println("<tr><th>Faculty Id</th><th>Name</th><th>Photograph</th></tr>");
				do {
					if(i>=5){
						out.print("<tr>");
				
					}
					String id=rs.getString(1);
					String name=rs.getString(2);
					out.println("<td><table border=0>");

					out.println("<tr><td><img class='askmodal' id="+id+" name="+name+" src=fpic/" + rs.getString(10)+ " width=370 height=280></td></tr>");
					out.println("<tr><td><center><h4><b><i><u>" + name + "</u></i><b></h4></center></td></tr>");
					out.println("</table></td>");
					if(i==4){out.print("</tr>");		i=0;}
					i++;
				} while (rs.next());
			} else {
				out.println("<b><i>Record Not Found</i></b>");
			}
			out.println("</table>");
			
	
			  
				
			  	out.println("<!--Group Modal-->");

		    	out.println("<!-- Modal -->");
		    	out.println("<div id='question' class='modal fade ' role='dialog'>");
		    	out.println("  <div class='modal-dialog'>");

		    	out.println("    <!-- Modal content-->");
		    	out.println("    <div class='modal-content'>");
		    	out.println("      <div class='modal-header'>");
		    	out.println("        <button type='button' class='close' data-dismiss='modal'>&times;</button>");
		    	out.println("        <h4 class='modal-title fname'>View</h4>");
		    	out.println("      </div>");
		    	out.println("      <div class='modal-body'>");
		            

			out.println("<center><table class='table'>");
			  
			
			  out.println("<tr><td><b><i>Question:</i></b></td><td><input  type=hidden    name=fid id=fid><textarea name=qus  id=qus rows=3 cols=35 class='form-control'></textarea></td></tr>");
			  
			out.println("</table>");
	    	out.println("    <div id=result></div>  </div>");
	    	out.println("      <div class='modal-footer'>");
	    	out.println("        <input type=button value=submit class='btn btn-info saveq'><button type='button' class='btn btn-raised btn-default' data-dismiss='modal'>Close</button>");
	    	out.println("      </div>");
	    	out.println("    </div>");
	    	out.println("  </div>");
	    	out.println("</div>");
	  	out.println("</div>");
		out.println("</div>");

		out.println("<!--End Group Modal-->");
			////end view
			
			
			
			out.println("</html>");
			out.flush();
		} catch (Exception e) {
		}

	}

}
