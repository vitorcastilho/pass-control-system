package com.passcontrol.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.passcontrol.entity.Pass;
import com.passcontrol.entity.TypePass;

public class PassDTO {

	private Long id;
	private TypePass type;
	private int number;
	private boolean isActive;

	public PassDTO(Pass pass) {
		this.id = pass.getId();
		this.type = pass.getType();
		this.number = pass.getNumber();
		this.isActive = pass.getIsActive();
	}
	
	@Override
	public String toString() {
		return type + "" + String.format("%04d", number) ;
	}

	public static List<PassDTO> convert(List<Pass> pass) {
		return pass.stream().map(PassDTO::new).collect(Collectors.toList());
	}
	
	public static Pass convertPass(Pass nextPass) {
		return nextPass;
		//.stream().map(PassDTO::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public TypePass getType() {
		return type;
	}

	public int getNumber() {
		return number;
	}

	public boolean isActive() {
		return isActive;
	}

}
