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
 * Servlet implementation class ViewAllQuestion
 */
@WebServlet("/ViewAllQuestion")
public class ViewAllQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out=response.getWriter();
	      try{HttpSession ses=request.getSession(false);
	       out.println("<html><center>");
	       out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
			out.println("<script src='asset/bootstrap.min.js'></script>");
			out.println("<script src='asset/qviewjs.js'></script>");
			
			out.println("<link href='asset/css/bootstrap.css' type='text/css' rel='stylesheet'>");
			out.println("<link href='asset/css/bootstrap-material-design.css' type='text/css' rel='stylesheet'>");

	    String fid=   ses.getValue("FID").toString();
	       
	       ResultSet rs=QuestionDAO.DisplaySelectedRecord(fid);
	       
	       if(rs.next())
	       {
	       out.println("<table border=1 id=ans>");
	       out.println("<caption><b><i><u><h1>List of Question</h1></u></i></b></caption>");
	       out.println("<tr><th>studentid</th><th>Question</th></tr>");
	       do
	       {String id= rs.getString(1);
	       String stid=   rs.getString(2);
	    	   
	    	   out.println("<tr><td>"+stid+"</td><td>"+rs.getString(5)+"</td><td><a  class='askmodal' qus=\""+rs.getString(5)+"\" qid=\""+id+"\" studentid="+stid+" \">Ans</a></td></tr>");
	    	  
	       }while(rs.next());
	       out.println("</table>");
	       }
	       else
	       {
	    	 out.println("<b><i>Record Not Found</i></b>");  
	       }
	       out.println("<!--Group Modal-->");

	    	out.println("<!-- Modal -->");
	    	out.println("<div id='ansview' class='modal fade ' role='dialog'>");
	    	out.println("  <div class='modal-dialog'>");

	    	out.println("    <!-- Modal content-->");
	    	out.println("    <div class='modal-content'>");
	    	out.println("      <div class='modal-header'>");
	    	out.println("        <button type='button' class='close' data-dismiss='modal'>&times;</button>");
	    	out.println("        <h4 class='modal-title fname'>View</h4>");
	    	out.println("      </div>");
	    	out.println("      <div class='modal-body'>");
	            

		out.println("<center><table class='table'>");
		  
		
		  out.println("<tr><td><b><i>Answer:</i></b></td><td><input  type=hidden    name=qid id=qid><input  type=hidden    name=studentid id=studentid><textarea name=answer  id=answer rows=3 cols=35 class='form-control'></textarea></td></tr>");
		  out.println("<tr><td><b><i>Share:</i></b></td><td><select name=st id=st><option value='Share'>Share</option><option value='UnShare'>UnShare</option></select></td></tr>");
		  out.println("<a href=FileUpload>Upload Resource<br></a>");
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
		
		

	       
	       out.println("</center></html>");
	       out.flush();
	      }catch(Exception e){}
	}

}
