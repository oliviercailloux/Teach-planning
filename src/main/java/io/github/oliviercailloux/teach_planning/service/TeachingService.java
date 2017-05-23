package io.github.oliviercailloux.teach_planning.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import io.github.oliviercailloux.teach_planning.model.Teaching;
import io.github.oliviercailloux.teach_planning.utils.QueryHelper;

@ApplicationScoped
public class TeachingService {
	
	@Inject
	private QueryHelper qh;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public List<Teaching> getAll() {
		return em.createQuery(qh.selectAll(em.getCriteriaBuilder(),Teaching.class)).getResultList();
	}
	
	@Transactional
	public void persist(Teaching teacher) {
		em.persist(teacher);
	}
	
}