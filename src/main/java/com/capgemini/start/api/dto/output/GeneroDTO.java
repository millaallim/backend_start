package com.capgemini.start.api.dto.output;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Genero", description = "Ojeto de saída da entidade gênero")


public class GeneroDTO {
	
	private Long id;
	
	private String descricao;
	
	private LocalDateTime dataInclusao;
	
	private LocalDateTime dataAlteracao;

}
