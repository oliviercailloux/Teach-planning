package io.github.oliviercailloux.teach_planning.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import io.github.oliviercailloux.teach_planning.model.ChargeTeacher;
import io.github.oliviercailloux.teach_planning.utils.QueryHelper;

@ApplicationScoped
public class ChargeService {
		
		@Inject
		private QueryHelper qh;
		
		@PersistenceContext
		private EntityManager em;
		
		@Transactional(dontRollbackOn = Exception.class)
		public void persist(ChargeTeacher ct) {
			em.persist(ct);
		}
		
		@Transactional
		public List<ChargeTeacher> getAll() {
			return em.createQuery(qh.selectAll(em.getCriteriaBuilder(), ChargeTeacher.class)).getResultList();
		}	
}
