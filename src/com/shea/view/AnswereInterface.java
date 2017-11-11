package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class Answere
 */
@WebServlet("/AnswereInterface")
public class AnswereInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswereInterface() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  PrintWriter out=response.getWriter();
		  out.println("<html>");
		  out.println("<center><table>");
		  Calendar c=Calendar.getInstance();
		  String d=c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.DATE);
		
		  out.println("<form action=AnswerSubmit method=post>");
		  out.println("<caption><h2><i>Answere</i></h2></caption>");
		  out.println("<tr><td><b><i>Answere:</i></b></td><td><textarea name=sa rows=3 cols=30></textarea></td></tr>");
		  out.println("<tr><td>Date:</td><td><input type=text name=dt value='"+d+"' readonly></td></tr>");
		  out.println("<tr><td><input type=submit   value=Submit></td><td><input type=reset></td></tr>");
		  out.println("</table></center></html>");
}

}
