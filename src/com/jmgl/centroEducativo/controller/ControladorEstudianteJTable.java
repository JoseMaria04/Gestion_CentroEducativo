package com.jmgl.centroEducativo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.jmgl.centroEducativo.modelJPA.Estudiante;

public class ControladorEstudianteJTable {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");

	/**
	 * 
	 * @return
	 */
	public static List<Estudiante> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		
	    TypedQuery<Estudiante> query = em.createNamedQuery("Estudiante.findAll", Estudiante.class);
	    return query.getResultList();
	}
	
	/** 
	 * 
	 * @return
	 */
	public static String[] getColumnTittle() {
		return new String[] {"Id", "Nombre", "1º apellido", "2º apellido", "DNI",  "Direccion", "Email", "Teléfono", "Sexo"};
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static Object[][] datosTabla() {
		List<Estudiante> estudiante =  findAll();
		Object[][] o = new Object[estudiante.size()][9];
		for (int i = 0; i < estudiante.size(); i++) {
			Estudiante es = estudiante.get(i);
			o[i][0] = es.getId();
			o[i][1] = es.getNombre();
			o[i][2] = es.getApellido1();
			o[i][3] = es.getApellido2();
			o[i][4] = es.getDni();
			o[i][5] = es.getDireccion();
			o[i][6] = es.getEmail();
			o[i][7] = es.getTelefono();
			o[i][8] = es.getTipologiasexo();

		}
		
		return o;
	}
	
	/** 
	 * 
	 * @return
	 */
	public static String[] cabeceraTabla() {
		return new String[] {"Id", "Nombre", "1º apellido", "2º apellido", "DNI",  "Direccion", "Email", "Teléfono", "Sexo"};
	}
	
	
	/**
	 * 
	 * @param string
	 */
	public static Estudiante findbyId(int idDocente) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Estudiante e = new Estudiante();
				
		Query q = em.createNativeQuery("SELECT * FROM estudiante where id = ?", Estudiante.class);

		q.setParameter(1, idDocente);
		
		e = (Estudiante) q.getSingleResult();
		
		
		em.close();		
		return e;
		
	}
	
	/**
	 * 
	 */
	public static void modificarEntidad (Estudiante l) {
		EntityManager em = entityManagerFactory.createEntityManager();		
		
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
		em.close();
	}
}
