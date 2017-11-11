package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shea.dao.FacultyDAO;


/**
 * Servlet implementation class FacultyEditDelete
 */
@WebServlet("/FacultyEditDelete")
public class FacultyEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try{String fid=request.getParameter("fid");
		   
		ResultSet rs=FacultyDAO.DisplayById(fid);
		     PrintWriter out=response.getWriter();
		     if(rs.next())
		     {
		      out.println("<html><form action=FacultyFinalEditDelete>");
		      out.println("<table><tr><td>");
			  out.println("<table>");
			  out.println("<caption><h2><i>Faculty Update/Delete</i></h2></caption>");
			  out.println("<tr><td><b><i>Faculty Id:</i></b></td><td><input type=text name=fid size=40 value="+rs.getString(1)+"></td></tr>");
			  out.println("<tr><td><b><i>Name:</i></b></td><td><input type=text name=fn size=40 value="+rs.getString(2)+"></td></tr>");
			  out.println("<tr><td><b><i>Birth Date:</i></b></td><td><input type=text name=fbd size=40 value="+rs.getString(3)+"></td></tr>");
			  if(rs.getString(4).equals("Male"))
			  {
			  out.println("<tr><td><b><i>Gender:</i></b></td><td><input type=radio name=fg value=Male Checked>Male<input type=radio name=fg value=Female>Female</td></tr>");
			  }
			  else
			  {
				  out.println("<tr><td><b><i>Gender:</i></b></td><td><input type=radio name=fg value=Male>Male<input type=radio name=fg value=Female checked>Female</td></tr>");	  
			  }
				  
			  
			  out.println("<tr><td><b><i>Address:</i></b></td><td><textarea name=fa rows=3 cols=30>"+rs.getString(5)+"</textarea></td></tr>");
			  out.println("<tr><td><b><i>Contact No:</i></b></td><td><input type=text name=fc size=40 value="+rs.getString(6)+"></td></tr>");
			  out.println("<tr><td><b><i>Email Id:</i></b></td><td><input type=text name=fm size=40 value="+rs.getString(7)+"></td></tr>");
			  out.println("<tr><td><b><i>Qualifaction:</i></b></td><td><input type=text name=fq size=40 value="+rs.getString(8)+"></td></tr>");

			  out.println("<tr><td><b><i>Branch:</i></b></td><td><select name=fb><option>"+rs.getString(9)+"</option><option value=MCA>MCA</option><option value=BE>BE</option><option value=BSC>BSC</option></select></td></tr>");
			  out.println("</table></td>");
			  out.print("<td><img src=pic/"+rs.getString(10)+" width=200 height=200><br><br><input type=file name=fp></td></tr></table><br><br>");
			  out.println("<input type=submit value=Update name=btn><input type=submit value=Delete name=btn></form></html>");
					  
					  
			   
		     }
			  out.flush();
		   }catch(Exception e)
		   {}
		
		

	
	}

}
