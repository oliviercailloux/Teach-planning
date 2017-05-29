package io.github.oliviercailloux.teach_planning.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import io.github.oliviercailloux.teach_planning.model.Login;
import io.github.oliviercailloux.teach_planning.utils.QueryHelper;

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
	
	@Transactional
	public String isExistLoginPassword(String login, String password) {
		for(Login lm : this.getAll()) {
			if(lm.getLogin().equals(login)) {
				if(lm.getPassword().equals(password)) {
					return "OK";
				}
				return "Le mot de passe est incorrect pour le login : " + login;
			}
	    }
		return "Le login : '" + login + "', n'existe pas !";
	}
	
	@Transactional
	public String getTypeAccount(String login) {
		for(Login lm : this.getAll()) {
			if(lm.getLogin().equals(login)) {
				return lm.getTypeAccount().toString();
			}
		}
		return null;
	}

}
