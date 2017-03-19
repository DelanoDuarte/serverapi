/**
 * 
 */
package br.simpleapp.repository;

import java.util.List;

import br.simpleapp.domain.Funcionario;

/**
 * @author delano.duarte
 *
 */
public interface IFuncionarioRepository {

	public void save(Funcionario funcionario);

	public List<Funcionario> all();
	
	public Funcionario findById(Long id);
}
