package com.serainlucas.apiautomatos.models;

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
	private Simbolos[] simbolos;
	
	
	
	public void declaraFuncao(){
		System.out.println("void " + this.name + "();\n" );
	}
	
	public void escreveFuncao(){
		System.out.println("void " + this.name + "()" + "\n"
				+ "{");
		
		if(!simboloVazio()) {
			for (Simbolos simbolos2 : simbolos) {
				simbolos2.printaIfSimbolo();
				System.out.println("\telse");
			}
		}else {
			System.out.println("if(f[p]==0)\n"
					+ "\t{\n"
					+ "\t\taceita();\n"
					+ "\t}\n"
					+"\telse\n");
		}
		System.out.println(
				"\t\trejeita();\n"
				+ "}\n");
		
	}
	public boolean simboloVazio() {
		if(this.isFinal.equals("true"))
			if(this.getSimbolos()==null) {
				return true;
			}
		return false;
				 
				
	}
	
	
	

}
