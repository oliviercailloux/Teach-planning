package teach_planning.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import teach_planning.model.TeacherModel;

@ApplicationScoped
public class TeacherService {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public List<TeacherModel> getAll() {
		return em.createNamedQuery("TeacherModel.getAll", TeacherModel.class).getResultList();
	}
	
	@Transactional
	public void persist(TeacherModel teacher) {
		em.persist(teacher);
	}
}
