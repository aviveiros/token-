package br.com.andreviveiros.tokengenerator.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.andreviveiros.tokengenerator.form.UsuarioForm;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
	private Long id;
	
	@Column(name = "usu_nome_razao_social",unique = true)
	private String nomeRazaoSocial;
	
	
	@Column(name = "usu_cpf_cnpj",unique = true)
	private String cpfCnpj;
	
	@Column(name = "usu_email",unique = true)
	private String email;
	
	
	@Column(name = "usu_password",unique = true)
	private String password;
		
	
}
