package com.shea.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shea.dao.StudentDAO;
import com.shea.model.Student;

/**
 * Servlet implementation class StudentFinalEditDelete
 */
@WebServlet("/StudentFinalEditDelete")
public class StudentFinalEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentFinalEditDelete() {
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
		  { Student S=new Student();  
		 // F.setFacultyid(request.getParameter("fid"));
		  S.setStudentid(request.getParameter("sid"));
		  S.setStudentname(request.getParameter("sn"));
		  S.setGender(request.getParameter("sg"));
		  S.setEmailid(request.getParameter("se"));
		  S.setBranch(request.getParameter("sb"));
		  S.setYear(request.getParameter("sy"));
		  S.setSemester(request.getParameter("ss"));
		  S.setContactno(request.getParameter("sc"));
		  S.setFcontactno(request.getParameter("sf"));
		  S.setDob(request.getParameter("sd"));
		  S.setAddress(request.getParameter("sa"));
		  S.setPhotograph(request.getParameter("sp"));
		  
		  boolean st=StudentDAO.EditRecord(S);
		   
		  }
		  else if(btn.equals("Delete"))
		  { String sid=request.getParameter("sid");
		  boolean st=StudentDAO.DeleteById(sid);
		   }
		  response.sendRedirect("StudentDisplayAll");

		
		
	}

}
