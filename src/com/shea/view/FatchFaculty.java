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

import com.shea.dao.DBHelper;
import com.shea.dao.FacultyDAO;

/**
 * Servlet implementation class FatchFaculty
 */
@WebServlet("/FatchFaculty")
public class FatchFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FatchFaculty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		PrintWriter out=response.getWriter();
		  ResultSet rs=FacultyDAO.DisplayAllRecord();
		  ArrayList<JSONObject> list= DBHelper.getFormattedResult(rs);
		  out.println(list);

	}

}
