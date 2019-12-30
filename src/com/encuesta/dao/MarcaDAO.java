package com.encuesta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.encuesta.model.Conexion;
import com.encuesta.model.Marca;

public class MarcaDAO {
	private Conexion con;
	private Connection connection;
 
	public MarcaDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	// listar todos los productos
	public List<Marca> listarMarcas() throws SQLException {

		List<Marca> listarMarcas = new ArrayList<Marca>();
		String sql = "SELECT * FROM marca";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			String id = resulSet.getString("id");
			String detalle = resulSet.getString("marca");
			Marca marca = new Marca(id, detalle);
			listarMarcas.add(marca);
		}
		con.desconectar();
		return listarMarcas;
	}
}
