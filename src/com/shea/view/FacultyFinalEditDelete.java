package com.shea.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shea.dao.FacultyDAO;
import com.shea.model.Faculty;


/**
 * Servlet implementation class FacultyFinalEditDelete
 */
@WebServlet("/FacultyFinalEditDelete")
public class FacultyFinalEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyFinalEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String btn=request.getParameter("btn");
		  if(btn.equals("Update"))
		  { Faculty F=new Faculty();  
		  F.setFacultyid(request.getParameter("fid"));
		  F.setFacultyname(request.getParameter("fn"));
		  
		  F.setDob(request.getParameter("fbd"));
		  F.setGender(request.getParameter("fg"));
		  F.setAddress(request.getParameter("fa"));
		  F.setContactno(request.getParameter("fc"));
		  F.setEmailid(request.getParameter("fm"));
		  F.setQualifaction(request.getParameter("fq"));
		  F.setBranch(request.getParameter("fb"));
		  F.setPhotograph(request.getParameter("fp"));
		  
		  
		  
		  boolean st=FacultyDAO.EditRecord(F);
		   
		  }
		  else if(btn.equals("Delete"))
		  { String fid=request.getParameter("fid");
		  boolean st=FacultyDAO.DeleteById(fid);
		   }
		  response.sendRedirect("FacultyDisplayAll");

		
		
	}

}
