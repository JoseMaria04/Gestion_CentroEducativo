package com.jmgl.centroEducativo.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jmgl.centroEducativo.model.Curso;
import com.jmgl.centroEducativo.utils.ConnectionManager;

public class ControladorCurso {
	
	/**
	 * 
	 * @return
	 */
	private static Curso findFirst() {
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.curso order by id limit 1");
			
			Curso curso = null;
			if (rs.next()) {
				curso = new Curso();
				curso.setId(rs.getInt("id"));
				curso.setDescripcion(rs.getString("descripcion"));
			}
			
			rs.close();
			st.close();
			conn.close();
			return curso;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
