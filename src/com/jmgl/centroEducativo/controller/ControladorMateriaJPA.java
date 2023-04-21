package com.jmgl.centroEducativo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jmgl.centroEducativo.modelJPA.Materia;


public class ControladorMateriaJPA {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");

	public static List<Materia> findAllMateria (){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM materia", Materia.class);
		
		@SuppressWarnings("unchecked")
		List<Materia> l = (List<Materia>) q.getResultList();
		em.close();
		return l;
	}
}
