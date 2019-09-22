/**
 * 
 */
package br.com.springessential.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springessential.entities.Empresa;

/**
 * @author fernando
 *
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    
    Empresa findByCnpj(String cnpj);

}
