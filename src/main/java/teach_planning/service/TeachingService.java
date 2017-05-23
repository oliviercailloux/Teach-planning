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

import teach_planning.model.Teaching;
import teach_planning.utils.QueryHelper;

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