/**
 * 
 */
package br.simpleapp.bussiness;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.simpleapp.domain.Funcionario;
import br.simpleapp.repository.IFuncionarioRepository;

/**
 * @author delano.duarte
 *
 */
@RequestScoped
public class FuncionarioBusiness implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IFuncionarioRepository funcionarioRepository;

	public void save(Funcionario funcionario) {
		try {
			funcionarioRepository.save(funcionario);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public List<Funcionario> all() {
		try {
			return funcionarioRepository.all();
		} catch (Exception e) {
			return null;
		}
	}

	public Funcionario findById(Long id) {
		try {

			return funcionarioRepository.findById(id);
		} catch (Exception e) {
			return null;
		}
	}
}
