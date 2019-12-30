package com.encuesta;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encuesta.dao.LoginDAO;
import com.encuesta.model.User;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
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
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/Home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User(request.getParameter("login"), request.getParameter("pass"));
		try {
			System.out.print(loginDAO.validarLogin(user));
			if(loginDAO.validarLogin(user) == 1)
				doGet(request, response);
			else
				request.getRequestDispatcher("/Inicio.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
