package com.encuesta.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
 
import com.encuesta.model.Conexion;
import com.encuesta.model.EncuestaModel;

public class EncuestaDAO {
	private Conexion con;
	private Connection connection;
 
	public EncuestaDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public boolean registrarEncuesta(EncuestaModel encuestaModel) throws SQLException {
		String sql = "INSERT INTO encuesta (id, documento, email, comentarios, marca, fecha) VALUES(?,?,?,?,?,?)";
		
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);	
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		
		statement.setString(1, null);
		statement.setString(2, encuestaModel.getDocumento());
		statement.setString(3, encuestaModel.getEmail());
		statement.setString(4, encuestaModel.getComentarios());
		statement.setString(5, encuestaModel.getMarca());
		statement.setString(6, date.toString());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
}
