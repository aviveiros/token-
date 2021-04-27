package br.com.andreviveiros.tokengenerator.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andreviveiros.tokengenerator.dto.UsuarioDTO;
import br.com.andreviveiros.tokengenerator.form.UsuarioForm;
import br.com.andreviveiros.tokengenerator.service.imp.UsuarioServiceIMP;

@RestController
@RequestMapping(value = "/token-generator")
public class TokenResource {
	
	@Autowired
	UsuarioServiceIMP service;
	
	@GetMapping(path = "info-token/{token}")
	public ResponseEntity<String> infoToken(@PathVariable String token){
		
		return ResponseEntity.ok("info-token" + token);
		
	}
	
	@PostMapping(path = "save-user")
	public ResponseEntity<UsuarioDTO> saveUser(@Validated @RequestBody UsuarioForm usuarioForm){
		
		try {
			  return ResponseEntity.ok().body(this.service.save(usuarioForm));
			
		}catch (RuntimeException e) {
			  return ResponseEntity.badRequest().body(null);
		}

		
	}
	
	
}
