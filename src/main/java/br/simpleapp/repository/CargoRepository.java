/**
 * 
 */
package br.simpleapp.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.simpleapp.domain.Cargo;

/**
 * @author delano.duarte
 *
 */
@RequestScoped
public class CargoRepository implements ICargoRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.simpleapp.repository.ICargoRepository#save(br.simpleapp.domain.Cargo)
	 */
	@Inject
	private EntityManager em;

	@Override
	public void save(Cargo cargo) {
		try {
			em.merge(cargo);
		} catch (Exception e) {

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.simpleapp.repository.ICargoRepository#all()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Cargo> all() {
		try {
			return em.createQuery("from Cargo c").getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Cargo findById(Long id) {
		try {

			return em.find(Cargo.class, id);
		} catch (Exception e) {
			return null;
		}
	}

}
