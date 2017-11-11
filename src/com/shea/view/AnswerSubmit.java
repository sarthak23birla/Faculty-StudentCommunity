package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shea.dao.AnswereDAO;
import com.shea.dao.StudentDAO;
import com.shea.model.Answere;

/**
 * Servlet implementation class AnswerSubmit
 */
@WebServlet("/AnswerSubmit")
public class AnswerSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();

    try{HttpSession ses=request.getSession(false);

	Calendar c=Calendar.getInstance();
	String d=c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.DATE);
	Answere A=new Answere();
	A.setFacultyid(ses.getValue("FID").toString());
    A.setQuestionid(request.getParameter("qid"));
	A.setAnswere(request.getParameter("ans"));
	A.setDate(d);
	A.setStatus(request.getParameter("st"));
	A.setStudentid(request.getParameter("studentid"));
	boolean st=AnswereDAO.addNewRecord(A);
	  if(st)
	  {
		  out.println("<font color=green>Record Submitted.....</font>");
		  
	  }
	  else
	  {out.println("Fail to Submit Record...");
		  
	  }
	  out.flush();
	  }catch(Exception ee){
		  
	  }
	}
	
	}
	


