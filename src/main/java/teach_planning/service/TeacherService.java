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

import teach_planning.model.TeacherModel;
import teach_planning.utils.QueryHelper;

@ApplicationScoped
public class TeacherService {
	
	@Inject
	private QueryHelper qh;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public List<TeacherModel> getAll() {
		return em.createQuery(qh.selectAll(em.getCriteriaBuilder(),TeacherModel.class)).getResultList();
	}

	@Transactional
	public List<TeacherModel> getTeachings() {
		return em.createQuery(qh.selectAll(em.getCriteriaBuilder(),TeacherModel.class)).getResultList();
	}
	
	@Transactional
	public void persist(TeacherModel teacher) {
		em.persist(teacher);
	}
	
}