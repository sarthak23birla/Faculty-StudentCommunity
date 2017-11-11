package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.shea.dao.FileUploadDAO;
import com.shea.model.fileupload;


/**
 * Servlet implementation class FileSubmit
 */
@WebServlet("/FileSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

public class FileSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		fileupload F=new fileupload();
		HttpSession ses=request.getSession(false);
  	  String fid=   ses.getValue("FID").toString();
  	  
  	  	Calendar c=Calendar.getInstance();
  	  	String d=c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE);
	
		
		F.setFacultyid(fid);
		F.setFilename(request.getParameter("sn"));
		F.setFiletype(request.getParameter("sg"));
		F.setDate(d);
		
		Part part=request.getPart("file");
		String savepath="D:/project/FandSCommunity/WebContent/fload";
		FileUpload F1=new FileUpload(part,savepath);
		F.setFileURL(F1.filename);
		
		boolean st=FileUploadDAO.addNewRecord(F);
		  if(st)
		  {
			  out.println("<font color=green>Record Submitted.....</font>");
			  
		  }
		  else
		  {out.println("Fail to Submit Record...");
			  
		  }
		  out.flush();
		  }


	
	}
