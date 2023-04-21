package com.jmgl.centroEducativo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jmgl.centroEducativo.modelJPA.Profesor;


public class ControladorProfesorJPA {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");

	public static List<Profesor> findAllProfesor (){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM profesor", Profesor.class);
		
		@SuppressWarnings("unchecked")
		List<Profesor> l = (List<Profesor>) q.getResultList();
		em.close();
		return l;
	}
}
