package com.serainlucas.apiautomatos.models;

import java.util.ArrayList;
import java.util.List;

public class Arquivo {
	public static List<String>textos = new ArrayList<>();

	public static String getTextos() {
		String fileText = "";
		for (String string : textos) {
			fileText += string;
		}
		return fileText;
	}

	public static void setTextos(String texto) {
		textos.add(texto);
	}
	
	
}
