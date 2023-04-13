package com.jmgl.centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jmgl.centroEducativo.model.Estudiante;
import com.jmgl.centroEducativo.utils.ConnectionManager;

public class ControladorEstudiante {
	
	/**
	 * 
	 * @return
	 */
	public static List<Estudiante> findAll() {
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from estudiante");
			
			while (rs.next()) {
				Estudiante estudiante = new Estudiante();
				estudiante = new Estudiante();
				estudiante.setId(rs.getInt("id"));
				estudiante.setNombre(rs.getString("nombre"));
				estudiante.setApellido1(rs.getString("apellido1"));
				estudiante.setApellido2(rs.getString("apellido2"));
				estudiante.setDni(rs.getString("dni"));
				estudiante.setDireccion(rs.getString("direccion"));
				estudiante.setEmail(rs.getString("email"));
				estudiante.setTelefono(rs.getString("telefono"));
				estudiante.setIdSexo(rs.getInt("tipologiasexo"));
				estudiante.setImagen(rs.getBytes("imagen"));
				estudiante.setColor(rs.getString("color"));
				estudiantes.add(estudiante);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return estudiantes;
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	private static Estudiante getEntidadFromResultSet(String sql) {
		Estudiante estudiante = null;
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				estudiante = new Estudiante();
				estudiante.setId(rs.getInt("id"));
				estudiante.setNombre(rs.getString("nombre"));
				estudiante.setApellido1(rs.getString("apellido1"));
				estudiante.setApellido2(rs.getString("apellido2"));
				estudiante.setDni(rs.getString("dni"));
				estudiante.setDireccion(rs.getString("direccion"));
				estudiante.setEmail(rs.getString("email"));
				estudiante.setTelefono(rs.getString("telefono"));
				estudiante.setIdSexo(rs.getInt("tipologiasexo"));
				estudiante.setImagen(rs.getBytes("imagen"));
				estudiante.setColor(rs.getString("color"));
			}
			
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return estudiante;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Estudiante findFirst () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.estudiante order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Estudiante findLast () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.estudiante order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Estudiante findNext (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.estudiante where id > " + actualId + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Estudiante findPrevious (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.estudiante where id < " + actualId + " order by id desc limit 1");
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int modificar (Estudiante es) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update estudiante set nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?, direccion = ?, email = ?, telefono = ?, tipologiasexo = ?, imagen = ?, color = ? where id = ?");
		
			ps.setString(1, es.getNombre());
			ps.setString(2, es.getApellido1());
			ps.setString(3, es.getApellido2());
			ps.setString(4, es.getDni());
			ps.setString(5, es.getDireccion());
			ps.setString(6, es.getEmail());
			ps.setString(7, es.getTelefono());
			ps.setInt(8, es.getIdSexo());
			ps.setBytes(9, es.getImagen());
			ps.setString(10, es.getColor());
			ps.setInt(11, es.getId());
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
	 * @param c
	 * @return
	 */
	public static int insertar (Estudiante es) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into estudiante (id, nombre, apellido1, apellido2, dni, direccion, email, telefono, tipologiasexo, imagen, color) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
			int siguienteIdValido = getSiguientIdValido();
			ps.setInt(1, siguienteIdValido);
			ps.setString(2, es.getNombre());
			ps.setString(3, es.getApellido1());
			ps.setString(4, es.getApellido2());
			ps.setString(5, es.getDni());
			ps.setString(6, es.getDireccion());
			ps.setString(7, es.getEmail());
			ps.setString(8, es.getTelefono());
			ps.setInt(9, es.getIdSexo());
			ps.setBytes(10, es.getImagen());
			ps.setString(11, es.getColor());
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
	 * @param c
	 * @return
	 */
	public static int eliminar (int id) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"delete from estudiante where id = ?");
		
			ps.setInt(1, id);
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
	 * @return
	 */
	private static int getSiguientIdValido () {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"select max(id) from estudiante");
		
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
