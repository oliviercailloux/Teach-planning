package teach_planning.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@ApplicationScoped
public class QueryHelper {

	public <T> CriteriaQuery<T> selectAll(CriteriaBuilder criteriaBuilder, Class<T> type) { 
		final CriteriaQuery<T> query = criteriaBuilder.createQuery(type); 
		final Root<T> from = query.from(type); 
		query.select(from); 
		return query; 
	}

}
