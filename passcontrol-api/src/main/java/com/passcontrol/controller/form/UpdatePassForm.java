package com.passcontrol.controller.form;

import com.passcontrol.entity.Pass;
import com.passcontrol.entity.TypePass;
import com.passcontrol.repository.PassRepository;

public class UpdatePassForm {
	
	private Long id;
	private TypePass type;
	private int number;
	private Boolean isActive = false;
	
	public String desactivePass(PassRepository passRepository) {
		//consulta a nova senha
		Pass nextPass = passRepository.findNextPass();
		if (nextPass != null) {
			this.id = nextPass.getId();
			this.type = nextPass.getType();
			this.number = nextPass.getNumber();
			nextPass.setIsActive(false);
			passRepository.save(nextPass);
			return toString();
		}
		return null;
	}

	@Override
	public String toString() {
		return type + "" + String.format("%04d", number) ;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
