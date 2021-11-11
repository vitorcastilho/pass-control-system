package com.passcontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passcontrol.controller.form.UpdatePassForm;
import com.passcontrol.repository.PassRepository;

@RestController
@RequestMapping(value = "/manager")
public class ManagerController {
	
	@Autowired
	private PassRepository passRepository;
	
	@GetMapping("next-pass")
	public String getNextPass() {
		UpdatePassForm updatePass = new UpdatePassForm();
		return updatePass.desactivePass(passRepository);
	}
	
	@DeleteMapping("/reset-pass")
	public String restartPass() {
		passRepository.deleteAll();
		return "Fila de senhas reiniciada!";
	}

}
