package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		  out.println("<script src=asset/jquery-2.2.1.min.js></script>");
		  out.println("<script src=fills.js /></script>"); 
		  out.println("<html>");
		  out.println("<form action=FileSubmit method=post enctype=\"multipart/form-data\">");
		  //int id=FileUploadDAO.getID();
		  out.println("<center><table>");
		  out.println("<caption><h2><i>FILE UPLOAD</i></h2></caption>");
		  out.println("<tr><td><b><i>File Name:</i></b></td><td><input type=text   name=sn size=40 required='required'></br></td></tr>");
		  out.println("<tr><td><b><i>File Type:</i></b></td><td><input type=radio name=sg value=jpg>JPG<input type=radio name=sg value=pdf>PDF<input type=radio name=sg value=doc>DOC</td></tr>");
		  
		  out.println("<tr><td>File Name</td><td><input type=file name=file></td></tr>");
			 
		  out.println("<tr><td><input type=submit   value=Submit></td><td><input type=reset></td></tr>");
		  out.println("</table></center></form></html>");
		  out.flush();
		          
	}

	}
