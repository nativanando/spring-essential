/**
 * 
 */
package br.com.springessential.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author fernando
 *
 */
@Getter @Setter
@NoArgsConstructor
@ToString
public class EmpresaDto {
    private Long id;
    private String razaoSocial;
    private String cnpj;
}
