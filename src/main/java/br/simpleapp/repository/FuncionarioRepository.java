/**
 * 
 */
package br.simpleapp.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.simpleapp.domain.Funcionario;

/**
 * @author delano.duarte
 *
 */
@RequestScoped
public class FuncionarioRepository implements IFuncionarioRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.simpleapp.repository.IFuncionarioRepository#save(br.simpleapp.domain.
	 * Funcionario)
	 */

	@Inject
	private EntityManager em;

	@Override
	public void save(Funcionario funcionario) {
		try {
			em.merge(funcionario);
		} catch (Exception e) {

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.simpleapp.repository.IFuncionarioRepository#all()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> all() {
		try {
			return em.createQuery("from Funcionario f").getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Funcionario findById(Long id) {
		try {
			return em.find(Funcionario.class, id);
		} catch (Exception e) {
			return null;
		}
	}

}
