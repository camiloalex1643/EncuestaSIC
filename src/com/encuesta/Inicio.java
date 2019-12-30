package com.encuesta;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encuesta.dao.LoginDAO;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDAO loginDAO;
    
	public void init() {
		 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		 String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		 String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		 try {
			 loginDAO = new LoginDAO(jdbcURL, jdbcUsername, jdbcPassword);
		 } catch (Exception e) {
			 // TODO: handle exception
		 }
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/Inicio.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
