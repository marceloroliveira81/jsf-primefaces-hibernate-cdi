package util;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transacional
public class GerenciarTransacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	@AroundInvoke
	public Object executarTransacao(InvocationContext context) throws Exception {
		try {
			em.getTransaction().begin();
			Object result = context.proceed();
			em.getTransaction().commit();
			return result;
		} catch (Exception ex) {
			if(em.getTransaction() != null && em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			throw ex;
		} /*finally {
			em.close();
		}*/
	}
}