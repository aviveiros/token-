package br.com.andreviveiros.tokengenerator.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {
	
	
	private String nomeRazaoSocial;
	private String cpfCnpj;
	private String password;
	
}
