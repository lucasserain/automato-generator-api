package com.serainlucas.apiautomatos.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serainlucas.apiautomatos.models.Arquivo;
import com.serainlucas.apiautomatos.models.Automato;
import com.serainlucas.apiautomatos.models.Master;
import com.serainlucas.apiautomatos.service.AutomatoService;

@RestController
@RequestMapping(value="/automatos")
public class AutomatoController {
	
	@Autowired
	private AutomatoService automatoService;
	
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public String createAFN(@RequestBody Master automato) {
		
		automatoService.imprimeAutomato(automato);
		return Arquivo.getTextos();
	
	}
}
