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

import com.shea.dao.StudentDAO;
import com.shea.model.Student;

/**
 * Servlet implementation class StudentSubmit
 */
@WebServlet("/StudentSubmit")

@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

public class StudentSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out=response.getWriter();
		Student S=new Student();
		S.setStudentid(request.getParameter("sid"));
		S.setStudentname(request.getParameter("sn"));
		S.setGender(request.getParameter("sg"));
		S.setEmailid(request.getParameter("se"));
		S.setBranch(request.getParameter("sb"));
		S.setYear(request.getParameter("sy"));
		S.setSemester(request.getParameter("ss"));
		S.setSubject(request.getParameter("sub"));
		S.setContactno(request.getParameter("sc"));
		S.setFcontactno(request.getParameter("sf"));
		S.setDob(request.getParameter("sd"));
		S.setAddress(request.getParameter("sa"));
		//S.setPhotograph(request.getParameter("sp"));
		S.setPassword(request.getParameter("spass"));
		Part part=request.getPart("sp");
		String savepath="D:/project/FandSCommunity/WebContent/spic";
		 FileUpload F=new FileUpload(part,savepath);
		S.setPhotograph(F.filename);
		
		boolean st=StudentDAO.addNewRecord(S);
		  if(st)
		  {
			  out.println("<font color=green>Record Submitted.....</font><br><a href=StudentInterface>Click Here to Add More Student</a>");
			  
		  }
		  else
		  {out.println("Fail to Submit Record...");
			  
		  }
		  out.flush();
		  }


	
	}


