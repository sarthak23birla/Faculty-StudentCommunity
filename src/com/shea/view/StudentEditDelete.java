package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shea.dao.StudentDAO;

/**
 * Servlet implementation class StudentEditDelete
 */
@WebServlet("/StudentEditDelete")
public class StudentEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		 try{String sid=request.getParameter("sid");
		   
			ResultSet rs=StudentDAO.DisplayById(sid);
			     PrintWriter out=response.getWriter();
			     if(rs.next())
			     {
			      out.println("<html><form action=StudentFinalEditDelete>");
			      out.println("<table><tr><td>");
				  out.println("<table>");
				  out.println("<caption><h2><i>Student Update/Delete</i></h2></caption>");
				  out.println("<tr><td><b><i>Student Id:</i></b></td><td><input type=text name=sid size=40 value="+rs.getString(1)+"></td></tr>");
				  out.println("<tr><td><b><i>Name:</i></b></td><td><input type=text name=sn size=40 value="+rs.getString(2)+"></td></tr>");
				  if(rs.getString(3).equals("Male"))
				  {
				  out.println("<tr><td><b><i>Gender:</i></b></td><td><input type=radio name=sg value=Male Checked>Male<input type=radio name=sg value=Female>Female</td></tr>");
				  }
				  else
				  {
					  out.println("<tr><td><b><i>Gender:</i></b></td><td><input type=radio name=sg value=Male>Male<input type=radio name=sg value=Female checked>Female</td></tr>");	  
				  }
					  
				  out.println("<tr><td><b><i>Email Id:</i></b></td><td><input type=text name=se size=40 value="+rs.getString(4)+"></td></tr>");
				  out.println("<tr><td><b><i>Branch:</i></b></td><td><select name=sb><option value="+rs.getString(5)+">"+rs.getString(5)+"</option></select></td></tr>");
				  out.println("<tr><td><b><i>Year:</i></b></td><td><select name=sy><option value="+rs.getString(6)+">"+rs.getString(6)+"</option></select></td></tr>");
				  out.println("<tr><td><b><i>Semester:</i></b></td><td><select name=ss><option value="+rs.getString(7)+">"+rs.getString(7)+"</option></select></td></tr>");
				  out.println("<tr><td><b><i>Contact No:</i></b></td><td><input type=text name=sc size=40 value="+rs.getString(8)+"></td></tr>");
				  out.println("<tr><td><b><i>Father Contact No:</i></b></td><td><input type=text name=sf size=40 value="+rs.getString(9)+"></td></tr>");
				  out.println("<tr><td><b><i>Birth Date:</i></b></td><td><input type=text name=sd size=40 value="+rs.getString(10)+"></td></tr>");

				  out.println("<tr><td><b><i>Address:</i></b></td><td><textarea name=sa rows=3 cols=30>"+rs.getString(11)+"</textarea></td></tr>");

				  out.println("</table></td>");
				  out.print("<td><img src=spic/"+rs.getString(12)+" width=200 height=200><br><br><p style='display:none;'><input type=file name=sp></p></td></tr></table><br><br>");
				  out.println("<input type=submit value=Update name=btn><input type=submit value=Delete name=btn></form></html>");
						  
						  
				   
			     }
				  out.flush();
			   }catch(Exception e)
			   {}
			
			

		
		}

	}

	
