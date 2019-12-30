package com.encuesta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import com.encuesta.model.Conexion;
import com.encuesta.model.User;

public class LoginDAO {
	private Conexion con;
	private Connection connection;
 
	public LoginDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public int validarLogin(User user) throws SQLException {
		String sql = "SELECT COUNT(*) As existe FROM login WHERE login = ? AND pass = ? AND active = 1";
		String result = "";
		
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getLogin());
		statement.setString(2, user.getPass());
		
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			result = res.getString("existe");
		}
		res.close();
		con.desconectar();
		return Integer.parseInt(result);
	}
}
