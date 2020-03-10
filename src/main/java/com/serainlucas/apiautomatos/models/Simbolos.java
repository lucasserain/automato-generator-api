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
		Arquivo.setTextos("\tif(f[p] == "+"'"+this.getName()+"'" +")\n" + 
				"\t\t{\n" + 
				"\t\t\tp++;\n" + 
				"\t\t\t"+this.getEstado()+"();\n" + 
				"\t\t}\n");
	}
	
	public void printaIfSimboloGoto() {
		Arquivo.setTextos("\tif(f[p] == "+"'"+this.getName()+"'" +")\n" + 
				"\t\t{\n" + 
				"\t\t\tp++;\n" + 
				"\t\t\tgoto "+this.getEstado()+";\n" + 
				"\t\t}");
	}

	
	
}
