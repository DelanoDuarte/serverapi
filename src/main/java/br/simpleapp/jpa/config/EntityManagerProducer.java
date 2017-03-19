/**
 * 
 */
package br.simpleapp.jpa.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author delano.duarte
 *
 */
@ApplicationScoped
public class EntityManagerProducer {

	@PersistenceContext
	private EntityManager entityManager;

	@RequestScoped
	@Produces
	public EntityManager getEntityManager() {
		return entityManager;
	}
}