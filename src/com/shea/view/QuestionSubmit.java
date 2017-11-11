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

import com.shea.dao.QuestionDAO;
import com.shea.model.Question;

/**
 * Servlet implementation class QuestionSubmit
 */
@WebServlet("/QuestionSubmit")
public class QuestionSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
			PrintWriter out=response.getWriter();
			try {
				 HttpSession ses=request.getSession(false);
		
			Question q=new Question();  
				Calendar c=Calendar.getInstance();
				  String d=c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.DATE);
				 String sid=ses.getValue("SID").toString();
			  q.setFacultyid(request.getParameter("fid"));
			 q.setQuestion(request.getParameter("qus"));
		q.setDate(d);
		q.setStudentid(sid);
		
			 boolean st=QuestionDAO.addNewRecord(q);
			  if(st)
			  { out.println("<font color=green>Record Submitted.....</font>");
				  
			  }
			  else
			  {out.println("Fail to Submit Record...");
				  
			  }
			  out.flush();
			}
			catch(Exception ee){}
			}}






