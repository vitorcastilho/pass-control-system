package com.passcontrol.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.passcontrol.controller.dto.PassDTO;
import com.passcontrol.controller.form.PassForm;
import com.passcontrol.entity.Pass;
import com.passcontrol.repository.PassRepository;

@RestController
@RequestMapping(value = "/pass")
public class PassController {

	@Autowired
	private PassRepository passRepository;

	@GetMapping
	public String getAllNextPass() {
		List<Pass> pass = passRepository.findByIsActive();
		return PassDTO.convert(pass).toString();
	}

	@GetMapping("/old")
	public String getOldPass() {
		List<Pass> pass = passRepository.findByNotActive();
		return PassDTO.convert(pass).toString();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> newPass(@RequestBody @Valid PassForm form, UriComponentsBuilder uriBuilder) {
		Pass pass = form.convert();
		passRepository.save(pass);
		URI uri = uriBuilder.path("/pass/{id}").buildAndExpand(pass.getId()).toUri();
		return ResponseEntity.created(uri).body(new PassDTO(pass).toString());
	}

	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> newPass2(@RequestBody @Valid PassForm form, UriComponentsBuilder uriBuilder) {
		// pesquisa pela última senha cadastrada para aquele tipo de cliente N = Normal
		// ou P = Preferencial
		Pass lastPass = passRepository.findLastPass(form.getType().toString().charAt(0));

		Pass newPass = new Pass();
		// Existindo uma senha cadastrada para aquele tipo, monta uma nova senha baseada
		// na anterior
		if (lastPass != null) {
			newPass = form.convertPass(lastPass);
		} else {
			// Caso não exista uma senha daquele tipo cadastrada, um primeira senha é criada
			newPass = form.convert();
		}
		// Sava a nova senha na base de dados
		passRepository.save(newPass);

		URI uri = uriBuilder.path("/pass/{id}").buildAndExpand(newPass.getId()).toUri();
		return ResponseEntity.created(uri).body(new PassDTO(newPass).toString());
	}
}
