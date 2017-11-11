package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shea.dao.FacultyDAO;
import com.shea.model.Faculty;



/**
 * Servlet implementation class FacultyChkPwd
 */
@WebServlet("/FacultyChkPwd")
public class FacultyChkPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyChkPwd() {
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
		   Faculty F=FacultyDAO.chkPassword(request.getParameter("fid"),request.getParameter("pwd"));
		   if(F!=null)
		   {HttpSession ses=request.getSession();
			   ses.putValue("FID", F.getFacultyid());
			   ses.putValue("FNAME", F.getFacultyname());
			   ses.putValue("bid", F.getBranch());
			   ses.putValue("LDATE", new java.util.Date());
			// response.sendRedirect("ViewAllQuestion");
			  response.sendRedirect("FacultyProfile");
		   }
		   else
		   {out.println("<html><font color=red size=5>Invalid/UID and Password</font></html>");
			   
			   
		   }}catch(Exception ee)
		   {
			   
		   }
	}}
		   
		