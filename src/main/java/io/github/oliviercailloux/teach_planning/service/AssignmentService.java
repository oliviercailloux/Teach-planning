package io.github.oliviercailloux.teach_planning.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import io.github.oliviercailloux.teach_planning.model.Assignment;
import io.github.oliviercailloux.teach_planning.utils.QueryHelper;

@ApplicationScoped
public class AssignmentService {
	
	@Inject
	private QueryHelper qh;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Assignment assignment) {
		em.persist(assignment);
	}
	
	@Transactional
	public List<Assignment> getAll() {
		return em.createQuery(qh.selectAll(em.getCriteriaBuilder(), Assignment.class)).getResultList();
	}
}
