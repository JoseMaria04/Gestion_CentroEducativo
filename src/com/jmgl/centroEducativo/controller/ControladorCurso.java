package com.jmgl.centroEducativo.controller;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jmgl.centroEducativo.model.Curso;
import com.jmgl.centroEducativo.utils.ConnectionManager;

public class ControladorCurso {
	
	/**
	 * 
	 * @return
	 */
	public static List<Curso> findAll() {
		List<Curso> cursos = new ArrayList<Curso>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from curso");
			
			while (rs.next()) {
				Curso c = new Curso();
				c.setId(rs.getInt("id"));
				c.setDescripcion(rs.getString("descripcion"));
				cursos.add(c);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return cursos;
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	private static Curso getEntidadFromResultSet(String sql) {
		Curso curso = null;
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				curso = new Curso();
				curso.setId(rs.getInt("id"));
				curso.setDescripcion(rs.getString("descripcion"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return curso;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Curso findFirst () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.curso order by id limit 1");
	}
	
	/**
	 * 
	 * @return
	 */
	public static Curso findLast () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.curso order by id desc limit 1");
	}
	
	/**
	 * 
	 * @return
	 */
	public static Curso findNext (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.curso where id > " + actualId + " order by id limit 1");
	}
	
	/**
	 * 
	 * @return
	 */
	public static Curso findPrevious (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.curso where id < " + actualId + " order by id desc limit 1");
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int modificar (Curso c) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update curso set descripcion = ? where id = ?");
		
			ps.setString(1, c.getDescripcion());
			ps.setInt(2, c.getId());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int save (Curso c) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into curso (id, descripcion) values(?, ?)");
		
			int siguienteIdValido = getSiguienteIdValidoCurso(conn);
			ps.setInt(1, siguienteIdValido);
			ps.setString(2, c.getDescripcion());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return siguienteIdValido;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int delete (int id) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"Delete from curso where id=?");
		
			ps.setInt(1, id);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	private static int getSiguienteIdValidoCurso(Connection conn) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select max(id) as maximoId "
				+ "from centroeducativo.curso");
	
		if (rs.next()) {
			return rs.getInt(1) + 1;
		}
		
		return 1;
	}
}
