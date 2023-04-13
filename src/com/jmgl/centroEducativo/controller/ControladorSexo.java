package com.jmgl.centroEducativo.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jmgl.centroEducativo.model.Sexo;
import com.jmgl.centroEducativo.utils.ConnectionManager;


public class ControladorSexo {
	/**
	 * 
	 * @return
	 */
	public static List<Sexo> findAll(int id) {
		List<Sexo> o = new ArrayList<Sexo>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from tipologiasexo order by id= " + id +" desc");
			
			while (rs.next()) {
				Sexo p = new Sexo();
				p = new Sexo();
				p.setId(rs.getInt("id"));
				p.setDescripcion(rs.getString("descripcion"));
				o.add(p);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return o;
	}
}
