package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shea.dao.StudentDAO;
import com.shea.model.Student;

/**
 * Servlet implementation class StudentChkPwd
 */
@WebServlet("/StudentChkPwd")
public class StudentChkPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentChkPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try
		{
		   Student S=StudentDAO.chkPassword(request.getParameter("sid"),request.getParameter("pwd"));
		   if(S!=null)
		   {HttpSession ses=request.getSession();
			   ses.putValue("SID", S.getStudentid());
			   ses.putValue("SNAME", S.getStudentname());
			   ses.putValue("bid", S.getBranch());
			   ses.putValue("LDATE", new java.util.Date());
			   response.sendRedirect("StudentProfile");  
		   }
		   else
		   {out.println("<html><font color=red size=5>Invalid/UID and Password</font></html>");
			   
			   
		   }}catch(Exception ee)
		   {
			   
		   }
	}}
		   
		