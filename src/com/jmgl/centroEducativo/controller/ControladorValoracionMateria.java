package com.jmgl.centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jmgl.centroEducativo.model.ValoracionMateria;
import com.jmgl.centroEducativo.utils.ConnectionManager;

public class ControladorValoracionMateria {
	/**
	 * 
	 * @param rs
	 * @return
	 */
	private static ValoracionMateria getEntidadFromResultSet(String sql) {
		ValoracionMateria valoracionMateria = null;
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				valoracionMateria = new ValoracionMateria();
				valoracionMateria.setId(rs.getInt("id"));
				valoracionMateria.setIdProfesor(rs.getInt("idProfesor"));
				valoracionMateria.setIdEstudiante(rs.getInt("idEstudiante"));
				valoracionMateria.setIdMateria(rs.getInt("idMateria"));
				valoracionMateria.setValoracion(rs.getInt("valoracion"));

			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return valoracionMateria;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ValoracionMateria findFirst () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionmateria order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static ValoracionMateria findLast () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionmateria order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static ValoracionMateria findNext (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionmateria where id > " + actualId + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static ValoracionMateria findPrevious (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionmateria where id < " + actualId + " order by id desc limit 1");
	}
	
	/**
	 * 
	 * @param va
	 * @return
	 */
	public static int modificar (ValoracionMateria va) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update valoracionmateria set idProfesor = ?, idEstudiante = ?, idMateria = ?, valoracion = ? where id = ?");
		
			ps.setInt(1, va.getIdProfesor());
			ps.setInt(2, va.getIdEstudiante());
			ps.setInt(3, va.getIdMateria());
			ps.setFloat(4, va.getValoracion());
			ps.setInt(5, va.getId());
			int rows = ps.executeUpdate();
			ps.close();
			conn.close();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @param va
	 * @return
	 */
	public static int insertar (ValoracionMateria va) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into valoracionmateria (id, idProfesor, idEstudiante, idMateria, valoracion) "
					+ " values (?, ?, ?, ?, ?)");
		
			int siguienteIdValido = getSiguientIdValido();
			ps.setInt(1, siguienteIdValido);
			ps.setInt(2, va.getIdProfesor());
			ps.setInt(3, va.getIdEstudiante());
			ps.setInt(4, va.getIdMateria());
			ps.setFloat(5, va.getValoracion());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return siguienteIdValido;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	private static int getSiguientIdValido () {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"select max(id) from valoracionMateria");
		
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int maximoIdActual = rs.getInt(1);
				return maximoIdActual + 1;
			}
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
