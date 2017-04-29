package controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.AutorDao;
import model.Autor;
import util.Transacional;

@Named
@RequestScoped
public class AutorController implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Autor autor;
	
	@Inject
	private AutorDao autorDao;
	
	private List<Autor> autores;
	
	@Transacional
	public void salvar() {
		autorDao.salvar(autor);
		this.autor = new Autor();
		this.autores = autorDao.listar();
	}
	
	public void prepararAlteracao(Autor autor) {
		this.autor = autor;
	}
	
	@Transacional
	public void excluir(Autor autor) {
		autorDao.deletar(autor);
		this.autores = autorDao.listar();
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Transacional
	public List<Autor> getAutores() {
		if (this.autores == null) {
			this.autores = autorDao.listar();
		}
		return autores;
	}
}