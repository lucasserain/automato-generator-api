package com.serainlucas.apiautomatos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.serainlucas.apiautomatos.models.Automato;
import com.serainlucas.apiautomatos.models.Master;
@Service
public class AutomatoService {
	
	public void imprimeAutomato(Master master) {
		
		if(master.getAutomato().get(0).getType().equals("function"))
			master.getAutomato().get(0).geraCodigoFuncao();
		else
			master.getAutomato().get(0).geraCodigoGoto();
		
		
	}

}
