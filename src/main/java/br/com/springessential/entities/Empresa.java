/**
 * 
 */
package br.com.springessential.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author fernando
 *
 */
@Entity
@Table(name = "empresa")
@NoArgsConstructor
@ToString(exclude = "funcionarios")
public class Empresa implements Serializable {

    private static final long serialVersionUID = -2672081483336381736L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter Long id;
    
    @Column(name = "razao_social", nullable = false)
    @Getter @Setter private String razaoSocial;
    
    @Column(name = "cnpj", nullable = false)
    @Getter @Setter private String cnpj;
    
    @Column(name = "data_criacao", nullable = false)
    @Getter @Setter private Date dataCriacao;
    
    @Column(name = "data_atualizacao", nullable = false)
    @Getter @Setter private Date dataAtualizacao;
    
    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter @Setter private List<Funcionario> funcionarios;
    
    @PrePersist
    public void prePersist() {
	final Date data = new Date();
	dataCriacao = data;
	dataAtualizacao = data;
    }
    
    @PreUpdate
    public void preUpdate() {
	final Date data = new Date();
	dataAtualizacao = data;
    }
   
}
