package com.passcontrol.controller.form;

import javax.validation.constraints.NotNull;

import com.passcontrol.entity.Pass;
import com.passcontrol.entity.TypePass;

public class PassForm {

	@NotNull
	private TypePass type;
	private int number;

	public Pass convert() {
		Pass pass = new Pass();
		pass.setType(type);
		pass.setNumber(1);
		return pass;
	}
	
	public Pass convertPass(Pass pass) {
		Pass newPass = new Pass();
		newPass.setType(pass.getType());
		newPass.setNumber(pass.getNumber() + 1);
		return newPass;
	}

	public TypePass getType() {
		return type;
	}

	public void setType(TypePass type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
