package com.serainlucas.apiautomatos.service;

import org.springframework.stereotype.Service;

import com.serainlucas.apiautomatos.models.Automato;
@Service
public class AutomatoService {
	
	public void imprimeAutomato(Automato automato) {
		
		automato.geraCodigo();
		
	}

}
