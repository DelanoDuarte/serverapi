/**
 * 
 */
package br.simpleapp.repository;

import java.util.List;

import br.simpleapp.domain.Cargo;

/**
 * @author delano.duarte
 *
 */
public interface ICargoRepository {

	public void save(Cargo cargo);

	public List<Cargo> all();
	
	public Cargo findById(Long id);
}
