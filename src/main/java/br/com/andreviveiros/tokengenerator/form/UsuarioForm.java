package br.com.andreviveiros.tokengenerator.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.andreviveiros.tokengenerator.model.Usuario;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class UsuarioForm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull @NotEmpty
	String nomeRazaoSocial;
	@NotNull @NotEmpty
	String cpfCnpj;
	@NotNull @NotEmpty
	String password;
	
	public Usuario convertTo() {
		
		Usuario usuario = new Usuario();
		usuario.setNomeRazaoSocial(this.nomeRazaoSocial);
		usuario.setCpfCnpj(this.cpfCnpj);
		usuario.setPassword(this.password);
		return usuario;
		
		
	}
	
}
