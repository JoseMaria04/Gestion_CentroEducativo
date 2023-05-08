package com.jmgl.centroEducativo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jmgl.centroEducativo.modelJPA.Estudiante;
import com.jmgl.centroEducativo.modelJPA.Tipologiasexo;

public class ControladorSexoJPA {
	/**
	 * 
	 * @param string
	 */
	public static List<Tipologiasexo> findbyId(int idSexo) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");
		EntityManager em = entityManagerFactory.createEntityManager();				
		Query q = em.createNativeQuery("select * from tipologiasexo order by id=? desc", Tipologiasexo.class);

		q.setParameter(1, idSexo);
		
		@SuppressWarnings("unchecked")
		List<Tipologiasexo> e = (List<Tipologiasexo>) q.getResultList();
		
		
		em.close();		
		return e;
		
	}
}
