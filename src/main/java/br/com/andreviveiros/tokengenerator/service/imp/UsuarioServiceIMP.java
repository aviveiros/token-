package br.com.andreviveiros.tokengenerator.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.andreviveiros.tokengenerator.dto.UsuarioDTO;
import br.com.andreviveiros.tokengenerator.form.UsuarioForm;
import br.com.andreviveiros.tokengenerator.model.Usuario;
import br.com.andreviveiros.tokengenerator.repository.UsuarioRepository;

@Service
public class UsuarioServiceIMP {
	
	UsuarioRepository usuarioRepository;
	BCryptPasswordEncoder cryptPasswordEncoder;
	
	@Autowired
	public UsuarioServiceIMP(UsuarioRepository usuarioRepository,  BCryptPasswordEncoder cryptPasswordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.cryptPasswordEncoder = cryptPasswordEncoder;
	}
	
	public UsuarioDTO save(UsuarioForm form) {
		
		Usuario usuario = this.usuarioRepository.save(form.convertTo());
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setCpfCnpj(usuario.getCpfCnpj());
		usuarioDTO.setNomeRazaoSocial(usuario.getNomeRazaoSocial());
		usuarioDTO.setPassword(cryptPasswordEncoder.encode(usuario.getPassword()));
		return usuarioDTO;
		
	}
	
	
}
