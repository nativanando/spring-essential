/**
 * 
 */
package br.com.springessential.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import br.com.springessential.enums.PerfilEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author fernando
 *
 */
@Entity
@Table(name = "funcionario")
@NoArgsConstructor
@ToString(exclude = "lancamentos")
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 6472232271153593355L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;
    
    @Column(name = "nome", nullable = false)
    @Getter @Setter private String nome;

    @Column(name = "email", nullable = false)
    @Getter @Setter private String email;

    @Column(name = "senha", nullable = false)
    @Getter @Setter private String senha;
    
    @Column(name = "cpf", nullable = false)
    @Getter @Setter private String cpf;
    
    @Column(name = "valor_hora", nullable = true)
    @Getter @Setter private BigDecimal valorHora;
    
    @Column(name = "qtd_horas_trabalho_dia", nullable = true)
    @Getter @Setter private Float qtdHorasTrabalhoDia;
    
    @Column(name = "qtd_horas_almoco", nullable = true)
    @Getter @Setter private Float qtdHorasAlmoco;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "perfil", nullable = false)
    @Getter @Setter private PerfilEnum perfil;
    
    @Column(name = "data_criacao", nullable = false)
    @Getter @Setter private Date dataCriacao;
    
    @Column(name = "data_atualizacao", nullable = false)
    @Getter @Setter private Date dataAtualizacao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Getter @Setter private Empresa empresa;
    
    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter @Setter private List<Lancamento> lancamentos;
    
    @PreUpdate
    public void preUpdate() {
	final Date date = new Date();
	dataAtualizacao = date;
    }
    
    @PrePersist
    public void prePersist() {
	final Date date = new Date();
	dataCriacao = date;
	dataAtualizacao = date;
    }
}
