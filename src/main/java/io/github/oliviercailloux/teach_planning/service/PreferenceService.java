package io.github.oliviercailloux.teach_planning.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import io.github.oliviercailloux.teach_planning.model.Preference;
import io.github.oliviercailloux.teach_planning.utils.QueryHelper;

@ApplicationScoped
public class PreferenceService {
	@Inject
	private QueryHelper qh;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Preference preference) {
		em.persist(preference);
	}
	
	@Transactional
	public List<Object[]> getAllTeachingsOfTeacher(int teacherid) {
		Query query = em.createQuery(
				"SELECT DISTINCT tg.name, p.choice"
				+ " FROM Teaching AS tg, Preference AS p, Teacher AS t"
				+ " WHERE tg.id = p.teachingId"
				+ " AND p.teacherId = "+teacherid, Object[].class);
		return query.getResultList();
	} 
	
	@Transactional
	public List<Preference> getAll() {
		return em.createQuery(qh.selectAll(em.getCriteriaBuilder(), Preference.class)).getResultList();
	}
}
