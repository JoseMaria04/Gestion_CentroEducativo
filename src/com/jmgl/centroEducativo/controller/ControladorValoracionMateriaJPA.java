package com.jmgl.centroEducativo.controller;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jmgl.centroEducativo.modelJPA.Valoracionmateria;




public class ControladorValoracionMateriaJPA {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");

	public static List<Valoracionmateria> findAllEstudiantes (int idProfesor, int idMateria){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM valoracionmateria where idProfesor = ? and idMateria = ?", Valoracionmateria.class);
		q.setParameter(1, idProfesor);
		q.setParameter(2, idMateria);


		
		@SuppressWarnings("unchecked")
		List<Valoracionmateria> l = (List<Valoracionmateria>) q.getResultList();
		em.close();
		return l;
	}
}
