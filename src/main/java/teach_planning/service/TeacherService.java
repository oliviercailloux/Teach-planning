package teach_planning.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import teach_planning.model.Teacher;
import teach_planning.utils.QueryHelper;

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