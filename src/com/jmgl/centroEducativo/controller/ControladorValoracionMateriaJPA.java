package com.jmgl.centroEducativo.controller;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jmgl.centroEducativo.modelJPA.Valoracionmateria;





public class ControladorValoracionMateriaJPA {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");

	public static Valoracionmateria findByProfesorAndMateriaAndEstudiante (int idProfesor, int idMateria, int idEstudiante){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM valoracionmateria where idProfesor = ? and idMateria = ? and idEstudiante = ?", Valoracionmateria.class);
		q.setParameter(1, idProfesor);
		q.setParameter(2, idMateria);
		q.setParameter(3, idEstudiante);
		
		Valoracionmateria l = new Valoracionmateria();

		try {
			l = (Valoracionmateria) q.getSingleResult();
		} catch (Exception e) {
			l = null;
		}
		em.close();
		return l;
	}
	
	/**
	 * 
	 */
	public static void modificarValoracionMateria (Valoracionmateria l) {
		EntityManager em = entityManagerFactory.createEntityManager();		
		
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 */
	public static void creacionValoracionMateria (Valoracionmateria l) {
		EntityManager em = entityManagerFactory.createEntityManager();		
		
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
}
