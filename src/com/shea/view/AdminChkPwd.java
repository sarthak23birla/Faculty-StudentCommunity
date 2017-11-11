package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shea.dao.AdminDAO;
import com.shea.model.Admin;


/**
 * Servlet implementation class AdminChkPwd
 */
@WebServlet("/AdminChkPwd")
public class AdminChkPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChkPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   PrintWriter out=response.getWriter();
	   Admin A=AdminDAO.chkPassword(request.getParameter("aid"),request.getParameter("pwd"));
	   if(A!=null)
	   {HttpSession ses=request.getSession();
		   ses.putValue("SAID", A.getAdminid());
		   ses.putValue("SANAME", A.getAdminname());
		   ses.putValue("LDATE", new java.util.Date());
		 response.sendRedirect("AdminHome");  
	   }
	   else
	   {out.println("<html><font color=red size=5>Invalid/UID and Password</font></html>");
		   
		   
	   }
	   
	
	}

}
