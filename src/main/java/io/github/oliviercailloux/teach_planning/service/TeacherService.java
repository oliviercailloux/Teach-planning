package io.github.oliviercailloux.teach_planning.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import io.github.oliviercailloux.teach_planning.model.Teacher;
import io.github.oliviercailloux.teach_planning.utils.QueryHelper;

@ApplicationScoped
public class TeacherService {
	
	@Inject
	private QueryHelper qh;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public List<Teacher> getAll() {
		return em.createQuery(qh.selectAll(em.getCriteriaBuilder(),Teacher.class)).getResultList();
	}

	@Transactional
	public List<Teacher> getTeachings() {
		return em.createQuery(qh.selectAll(em.getCriteriaBuilder(),Teacher.class)).getResultList();
	}
	
	@Transactional
	public void persist(Teacher teacher) {
		em.persist(teacher);
	}
	
}