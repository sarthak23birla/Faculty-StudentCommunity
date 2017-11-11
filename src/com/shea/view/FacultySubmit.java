package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.shea.dao.FacultyDAO;
import com.shea.model.Faculty;



/**
 * Servlet implementation class FacultySubmit
 */
@WebServlet("/FacultySubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

public class FacultySubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultySubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		  Faculty F=new Faculty();  
		  F.setFacultyid(request.getParameter("fid"));
		  F.setFacultyname(request.getParameter("fn"));
		  
		  F.setDob(request.getParameter("fbd"));
		  F.setGender(request.getParameter("fg"));
		  F.setAddress(request.getParameter("fa"));
		  F.setContactno(request.getParameter("fc"));
		  F.setEmailid(request.getParameter("fm"));
		  F.setQualifaction(request.getParameter("fq"));
		  F.setBranch(request.getParameter("fb"));
		 // F.setPhotograph(request.getParameter("fp"));
		  
		  
		  Part part=request.getPart("fp"); 
		  String savepath="D:/project/FandSCommunity/WebContent/fpic";
		 FileUpload Fp=new FileUpload(part,savepath);
		 F.setPhotograph(Fp.filename);
F.setPassword(request.getParameter("fpass"));
		  boolean st=FacultyDAO.addNewRecord(F);
		  if(st)
		  { out.println("<font color=green>Record Submitted.....</font><br><a href=FacultyInterface>Click Here to Add More Faculties</a>");
			  
		  }
		  else
		  {out.println("Fail to Submit Record...");
			  
		  }
		  out.flush();
		  	}}


