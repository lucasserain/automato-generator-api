package com.serainlucas.apiautomatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Simbolos {
	
	private String name;
	private String estado;
	
	public void printaIfSimbolo() {
		System.out.println("\tif(f[p] == "+"'"+this.getName()+"'" +")\n" + 
				"\t\t{\n" + 
				"\t\t\tp++;\n" + 
				"\t\t\t"+this.getEstado()+"();\n" + 
				"\t\t}");
	}
	

	
	
}
