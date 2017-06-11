package io.github.oliviercailloux.teach_planning.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	public List<Object[]> getAllAssignment() {
		Query query = em.createQuery(
				"SELECT DISTINCT t.firstname, t.lastname, tg.name"
				+ " FROM Teaching AS tg, Assignment AS a, Teacher AS t"
				+ " WHERE tg.id = a.teachingId"
				+ " AND  t.id = a.teacherId", Object[].class);
		return query.getResultList();
	} 
	
	@Transactional
	public List<Assignment> getAll() {
		return em.createQuery(qh.selectAll(em.getCriteriaBuilder(), Assignment.class)).getResultList();
	}
}
