package com.shea.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.shea.dao.BranchSemesterDAO;
import com.shea.dao.DBHelper;

/**
 * Servlet implementation class FetchSubject
 */
@WebServlet("/FetchSubject")
public class FetchSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out=response.getWriter();
		
		  ResultSet rs=BranchSemesterDAO.FetchSubject(request.getParameter("semid"));
		  ArrayList<JSONObject> list= DBHelper.getFormattedResult(rs);
		  
		   out.println(list);
	

	
	}

}
