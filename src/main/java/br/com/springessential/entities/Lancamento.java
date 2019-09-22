/**
 * 
 */
package br.com.springessential.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.springessential.enums.TipoEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author fernando
 *
 */
@Entity
@Table(name = "lancamento")
@NoArgsConstructor
@ToString
public class Lancamento implements Serializable {

    private static final long serialVersionUID = 7077712074355735002L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false)
    @Getter @Setter private Date data;
    
    @Column(name = "descricao", nullable = true)
    @Getter @Setter private String descricao;
    
    @Column(name = "localizacao", nullable = true)
    @Getter @Setter private String localizacao;
    
    @Column(name = "data_criacao", nullable = false)
    @Getter @Setter private Date dataCriacao;
    
    @Column(name = "data_atualizacao", nullable = false)
    @Getter @Setter private Date dataAtualizacao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    @Getter @Setter private TipoEnum tipo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Getter @Setter private Funcionario funcionario;
    
    @PreUpdate
    public void preUpdate() {
	final Date data = new Date();
	dataAtualizacao = data;
    }
    
    @PrePersist
    public void prePersit() {
	final Date data = new Date();
	dataCriacao = data;
	dataAtualizacao = data;
    }
}
