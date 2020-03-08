package com.serainlucas.apiautomatos.models;

import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Automato {
	private String name;
	private String type;
	private Estados[] estados;
	
	public void geraCodigo() {
		this.geraIncludes();
		this.declaraEstados();
		this.funcAceita();
		this.funcRejeita();
		this.gerarMain();
	}
	
	public void geraIncludes() {
		System.out.println(
				"#include <stdio.h>\n" + 
				"#include <conio.h>\n" + 
				"#include <stdlib.h>\n" + 
				"char f[200];\n" + 
				"int p;\n" + 
				"void aceita();\n" + 
				"void rejeita();\n\n");
	}
	
	public void declaraEstados() {
		for (Estados estadosIn : estados) {
			estadosIn.declaraFuncao();
		}
		for (Estados estadosIn : estados) {
			estadosIn.escreveFuncao();
		}
	}
	
	public void funcAceita() {
		System.out.println("void aceita()\n"
				+ "{\n"
				+ "\tprintf(\"\\nAceita\\n\");\n"
				+ "\tgetch();\n"
				+ "\texit(0);\n"
				+ "}\n");
	}
	
	public void funcRejeita() {
		System.out.println("void rejeita()\n"
				+ "{\n"
				+ "\tprintf(\"\\nRejeita\\n\");\n"
				+ "\tgetch();\n"
				+ "\texit(0);\n"
				+ "}\n");
	}
	
	public void gerarMain() {
		String initialState = this.getInitialState();
		System.out.println("int main()\n"
				+ "{\n"
				+ "\tp=0;\n"
				+ "\tprintf(\"Digite a sentenca:\\n\");\n"
				+ "\tgets(f);\n"
				+ "\t"+initialState+"();\n"
				+ "\treturn(0);\n"
				+ "}");
	}
	
	public String getInitialState() {
		for (Estados estados2 : estados) {
			if(estados2.getIsInitial().equals("true"))
				return estados2.getName();
		}
		return "NENHUM ESTADO INICIAL";
	}
	

	public Automato(String name, String type, Estados[] estados) {
		super();
		this.name = name;
		this.type = type;
		this.estados = estados;
	}
	
	
	
	

}
