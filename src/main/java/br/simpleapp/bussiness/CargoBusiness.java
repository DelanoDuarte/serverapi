/**
 * 
 */
package br.simpleapp.bussiness;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.simpleapp.domain.Cargo;
import br.simpleapp.repository.ICargoRepository;

/**
 * @author delano.duarte
 *
 */
@RequestScoped
public class CargoBusiness implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ICargoRepository cargoRepository;

	public void save(Cargo cargo) {
		try {
			cargoRepository.save(cargo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public List<Cargo> all() {
		try {
			return cargoRepository.all();
		} catch (Exception e) {
			return null;
		}
	}

	public Cargo findById(Long id) {
		try {
			return cargoRepository.findById(id);
		} catch (Exception e) {
			return null;
		}
	}
}
