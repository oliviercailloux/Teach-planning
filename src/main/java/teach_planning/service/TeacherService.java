package teach_planning.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import teach_planning.model.TeacherModel;

@ApplicationScoped
public class TeacherService {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public List<TeacherModel> getAll() {
		return em.createQuery(selectAll(TeacherModel.class)).getResultList();
	}
	
	@Transactional
	public void persist(TeacherModel teacher) {
		em.persist(teacher);
	}
	
	private <T> CriteriaQuery<T> selectAll(Class<T> type) {
		final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		final CriteriaQuery<T> query = criteriaBuilder.createQuery(type);
		final Root<T> from = query.from(type);
		query.select(from);
		return query;
	}
}
