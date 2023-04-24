package com.jmgl.centroEducativo.controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jmgl.centroEducativo.modelJPA.Estudiante;

public class ControladorEstudianteJPA {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");

	public static List<Estudiante> findAll (){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);

		@SuppressWarnings("unchecked")
		List<Estudiante> l =  (List<Estudiante>) q.getResultList();
		em.close();
		return l;
	}
}
