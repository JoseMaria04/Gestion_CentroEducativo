package com.jmgl.centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jmgl.centroEducativo.model.Profesor;
import com.jmgl.centroEducativo.utils.ConnectionManager;

public class ControladorProfesor {
	/**
	 * 
	 * @return
	 */
	public static List<Profesor> findAll() {
		List<Profesor> profesor = new ArrayList<Profesor>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from profesor");
			
			while (rs.next()) {
				Profesor p = new Profesor();
				p = new Profesor();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido1(rs.getString("apellido1"));
				p.setApellido2(rs.getString("apellido2"));
				p.setDni(rs.getString("dni"));
				p.setDireccion(rs.getString("direccion"));
				p.setEmail(rs.getString("email"));
				p.setTelefono(rs.getString("telefono"));
				p.setIdSexo(rs.getInt("tipologiasexo"));
				p.setImagen(rs.getBytes("imagen"));
				p.setColor(rs.getString("colorpreferido"));
				profesor.add(p);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return profesor;
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	private static Profesor getEntidadFromResultSet(String sql) {
		Profesor profesor = null;
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				profesor = new Profesor();
				profesor.setId(rs.getInt("id"));
				profesor.setNombre(rs.getString("nombre"));
				profesor.setApellido1(rs.getString("apellido1"));
				profesor.setApellido2(rs.getString("apellido2"));
				profesor.setDni(rs.getString("dni"));
				profesor.setDireccion(rs.getString("direccion"));
				profesor.setEmail(rs.getString("email"));
				profesor.setTelefono(rs.getString("telefono"));
				profesor.setIdSexo(rs.getInt("tipologiasexo"));
				profesor.setImagen(rs.getBytes("imagen"));
				profesor.setColor(rs.getString("colorpreferido"));

			}
			
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return profesor;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Profesor findFirst () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.profesor order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Profesor findLast () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.profesor order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Profesor findNext (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.profesor where id > " + actualId + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Profesor findPrevious (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.profesor where id < " + actualId + " order by id desc limit 1");
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int modificar (Profesor p) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update profesor set nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?, direccion = ?, email = ?, telefono = ?, tipologiasexo = ?, imagen = ?, colorPreferido = ? where id = ?");
		
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApellido1());
			ps.setString(3, p.getApellido2());
			ps.setString(4, p.getDni());
			ps.setString(5, p.getDireccion());
			ps.setString(6, p.getEmail());
			ps.setString(7, p.getTelefono());
			ps.setInt(8, p.getIdSexo());
			ps.setBytes(9, p.getImagen());
			ps.setString(10, p.getColor());
			ps.setInt(11, p.getId());
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
	public static int insertar (Profesor p) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into profesor (id, nombre, apellido1, apellido2, dni, direccion, email, telefono, tipologiasexo, imagen, color) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
			int siguienteIdValido = getSiguientIdValido();
			ps.setInt(1, siguienteIdValido);
			ps.setString(2, p.getNombre());
			ps.setString(3, p.getApellido1());
			ps.setString(4, p.getApellido2());
			ps.setString(5, p.getDni());
			ps.setString(6, p.getDireccion());
			ps.setString(7, p.getEmail());
			ps.setString(8, p.getTelefono());
			ps.setInt(9, p.getIdSexo());
			ps.setBytes(10, p.getImagen());
			ps.setString(11, p.getColor());
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
					"delete from profesor where id = ?");
		
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
					"select max(id) from profesor");
		
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
