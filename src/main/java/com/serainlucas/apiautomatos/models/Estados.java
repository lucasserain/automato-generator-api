package com.serainlucas.apiautomatos.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Estados {
	
	private String name;
	private String isFinal;
	private String isInitial;
	private List<Simbolos> simbolos;
	
	
	
	public void declaraFuncao(){
		Arquivo.setTextos("void " + this.name + "();\n\n" );
	}
	
	public void escreveFuncao(){
		
		Arquivo.setTextos("void " + this.name + "()" + "\n"
				+ "{\n");
		
		if(!simboloVazio()) {
			for (Simbolos simbolos2 : simbolos) {
				simbolos2.printaIfSimbolo();
				Arquivo.setTextos("\telse\n");
			}
		}else {
			Arquivo.setTextos("if(f[p]==0)\n"
					+ "\t{\n"
					+ "\t\taceita();\n"
					+ "\t}\n"
					+"\telse\n");
		}
		Arquivo.setTextos(
				"\t\trejeita();\n"
				+ "}\n\n");
		
	}
	public boolean simboloVazio() {
		if(isFinal.equals("true"))
			if(simbolos==null) {
				return true;
			}
		return false;
				 
				
	}
	
	public void escreveFuncaoGoto(){
		
		
		Arquivo.setTextos((this.name + ":" + "\n"));
		
		if(!simboloVazio()) {
			for (Simbolos simbolos2 : simbolos) {
				simbolos2.printaIfSimboloGoto();
				Arquivo.setTextos(("\telse\n"));
			}
		}else {
			Arquivo.setTextos("if(f[p]==0)\n"
					+ "\t{\n"
					+ "\t\tgoto REJEITA;\n"
					+ "\t}\n"
					+"\telse\n");
		}
		Arquivo.setTextos(
				"\t\tgoto REJEITA;\n");
		
		
	}
	
	

}
