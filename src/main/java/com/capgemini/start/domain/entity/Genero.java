package com.capgemini.start.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_genero")


public class Genero {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "id_genero", nullable = false)
	private Long id;
	
	@Column(name = "ds_genero", nullable = false)
	private String descricao;
	
	@Column(name = "dt_inclusao", nullable = false)
	private Date dataInclusao;
	
	@Column(name = "dt_alteracao", nullable = false)	
	private Date dataAlteracao;
}
