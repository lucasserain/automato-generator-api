package com.serainlucas.apiautomatos.controllers.form;

import com.serainlucas.apiautomatos.models.Automato;
import com.serainlucas.apiautomatos.models.Estados;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomatoForm {
	private String name;
	private String type;
	private Estados[] estados;
	
	public Automato converter() {
		return null;

	}

}
