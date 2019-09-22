/**
 * 
 */
package br.com.springessential.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springessential.dtos.EmpresaDto;
import br.com.springessential.responses.Response;

/**
 * @author fernando
 *
 */
@RestController
@RequestMapping("api/empresas")
public class EmpresaController {
    
    /**
     * @param empresaDto
     * @return ResponseEntity<Response<EmpresaDto>>
     */
    @PostMapping
    public ResponseEntity<Response<EmpresaDto>> cadastrar(@RequestBody EmpresaDto empresaDto) {
	Response<EmpresaDto> response = new Response<EmpresaDto>();
	
	empresaDto.setId(1L);
	response.setData(empresaDto);
	
	return ResponseEntity.ok(response);
    }

}
