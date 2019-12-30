package com.encuesta;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encuesta.dao.EncuestaDAO;
import com.encuesta.dao.LoginDAO;
import com.encuesta.dao.MarcaDAO;
import com.encuesta.model.EncuestaModel;
import com.encuesta.model.Marca;

/**
 * Servlet implementation class Encuesta
 */
@WebServlet("/Encuesta")
public class Encuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDAO loginDAO;
	MarcaDAO marcaDAO;
	EncuestaDAO encuestaDAO;
	
	public void init() {
		 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		 String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		 String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		 try {
			 loginDAO = new LoginDAO(jdbcURL, jdbcUsername, jdbcPassword);
			 marcaDAO = new MarcaDAO(jdbcURL, jdbcUsername, jdbcPassword);
			 encuestaDAO = new EncuestaDAO(jdbcURL, jdbcUsername, jdbcPassword);
		 } catch (Exception e) {
			 // TODO: handle exception
		 }
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Encuesta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Marca> listaMarcas = null;
		try {
			listaMarcas = marcaDAO.listarMarcas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("lista", listaMarcas);
		request.getRequestDispatcher("/Encuesta.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EncuestaModel encuestaModel = new EncuestaModel(request.getParameter("documento"), request.getParameter("email"), request.getParameter("comentarios"), request.getParameter("marca"));
		try {
			encuestaDAO.registrarEncuesta(encuestaModel);
			request.setAttribute("mensaje", 1);
			request.getRequestDispatcher("/Encuesta.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
