package com.serainlucas.apiautomatos.controllers.dto;

import com.serainlucas.apiautomatos.models.Automato;
import com.serainlucas.apiautomatos.models.Estados;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomatoDto {
	
  private String name;

  private String type;

  private Estados[] estados;

	public AutomatoDto(Automato afn) {
		super();
		this.name = afn.getName();
		this.type = afn.getType();
		this.estados = afn.getEstados();
	}
	  
	  	
	

}
