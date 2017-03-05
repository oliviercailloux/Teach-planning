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

import teach_planning.model.LoginModel;
import teach_planning.model.TeacherModel;
import teach_planning.utils.QueryHelper;

@ApplicationScoped
public class LoginService {
	
	@Inject
	private QueryHelper qh;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(LoginModel loginModel) {
		em.persist(loginModel);
	}
	
	@Transactional
	public List<LoginModel> getAll() {
		return em.createQuery(qh.selectAll(em.getCriteriaBuilder(), LoginModel.class)).getResultList();
	}
	
	@Transactional
	public List<String> getAllLogins() {
		final CriteriaQuery<String> query = em.getCriteriaBuilder().createQuery(String.class);
		final Root<LoginModel> from = query.from(LoginModel.class);
		query.select(from.get(LoginModel.getLogin()));
		return em.createQuery(query).getResultList();
	}

}
