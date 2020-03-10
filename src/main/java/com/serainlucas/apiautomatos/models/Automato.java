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
	private List<Estados> estados;
	
	public void geraCodigoFuncao() {
		this.geraIncludes();
		this.declaraEstados();
		this.funcAceita();
		this.funcRejeita();
		this.gerarMain();
	}
	
	public void geraCodigoGoto() {
		this.geraIncludesGoto();
		this.declaraMainGoto();
		this.declaraEstadosGoto();
		this.gotoAceita();
		this.gotoRejeita();
	}
	
	public void geraIncludes() {
		Arquivo.setTextos(
				"#include <stdio.h>\n" + 
				"#include <conio.h>\n" + 
				"#include <stdlib.h>\n" + 
				"char f[200];\n" + 
				"int p;\n" + 
				"void aceita();\n" + 
				"void rejeita();\n\n");
	}
	
	public void geraIncludesGoto() {
		Arquivo.setTextos(
				"#include <stdio.h>\n" + 
				"#include <conio.h>\n" + 
				"#include <stdlib.h>\n");
	}
	
	public void declaraMainGoto() {
		String initialState = this.getInitialState();
		Arquivo.setTextos(
				"int main()\n"
				+ "{\n"
				+ "\tchar f[200];\n"
				+ "\tint p;\n"
				+ "\n"
				+ "\tp=0;\n"
				+ "\tprintf(\"Digite a sentenca:\\n\");\n"
				+ "\tgets(f);\n"
				+ "\tgoto " + initialState+";\n");
	}
	
	
	public void declaraEstados() {
		for (Estados estadosIn : estados) {
			estadosIn.declaraFuncao();
		}
		for (Estados estadosIn : estados) {
			estadosIn.escreveFuncao();
		}
	}
	
	public void declaraEstadosGoto() {
		for (Estados estadosIn : estados) {
			estadosIn.escreveFuncaoGoto();
		}

	}
	
	public void funcAceita() {
		Arquivo.setTextos("void aceita()\n"
				+ "{\n"
				+ "\tprintf(\"\\nAceita\\n\");\n"
				+ "\tgetch();\n"
				+ "\texit(0);\n"
				+ "}\n");
	}
	
	public void funcRejeita() {
		Arquivo.setTextos("void rejeita()\n"
				+ "{\n"
				+ "\tprintf(\"\\nRejeita\\n\");\n"
				+ "\tgetch();\n"
				+ "\texit(0);\n"
				+ "}\n");
	}
	
	public void gotoAceita() {
		Arquivo.setTextos("ACEITA:\n"
				+ "\tprintf(\"\\nAceita\\n\");\n"
				+ "\tgetch();\n"
				+ "\texit(0);\n");
	}
	
	public void gotoRejeita() {
		Arquivo.setTextos("REJEITA:\n"
				+ "\tprintf(\"\\nRejeita\\n\");\n"
				+ "\tgetch();\n"
				+ "\texit(0);\n"
				+ "}\n");
	}
	
	public void gerarMain() {
		String initialState = this.getInitialState();
		Arquivo.setTextos("int main()\n"
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
	

	public Automato(String name, String type, List<Estados> estados) {
		super();
		this.name = name;
		this.type = type;
		this.estados = estados;
	}


	
	
	
	

}
