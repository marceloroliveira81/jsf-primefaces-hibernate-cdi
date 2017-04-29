package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Autor;

public class AutorDao {

	@Inject
	private EntityManager em;
	
	public void salvar(Autor autor) {
		if (autor.getId() == null) {
			em.persist(autor);
		} else {
			em.merge(autor);
		}
	}
	
	public void deletar(Autor autor) {
		em.remove(autor);
	}
	
	public Autor pequisarPorId(Autor autor) {
		return em.find(Autor.class, autor.getId());
	}
	
	@SuppressWarnings("unchecked")
	public List<Autor> listar() {
		return em.createQuery("from Autor").getResultList(); 
	}
	
}