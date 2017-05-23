package teach_planning.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import teach_planning.model.Login;
import teach_planning.utils.QueryHelper;

@ApplicationScoped
public class LoginService {
	
	@Inject
	private QueryHelper qh;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Login loginModel) {
		em.persist(loginModel);
	}
	
	@Transactional
	public List<Login> getAll() {
		return em.createQuery(qh.selectAll(em.getCriteriaBuilder(), Login.class)).getResultList();
	}

}
