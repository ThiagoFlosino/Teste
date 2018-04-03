package com.atislabs.buscador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atislabs.buscador.domain.Reuniao;
import com.atislabs.buscador.repository.service.BuscaSimplesService;
import com.atislabs.buscador.repository.service.GraphService;

@Controller
@RestController
public class BuscaSimplesController {

	@Autowired private GraphService Graphservice;
	@Autowired private BuscaSimplesService simplesService;
	

	@RequestMapping("/busca")
	@GetMapping
	public List<Reuniao> Busca(@RequestParam boolean buscaSemantica, @RequestParam String keyword) throws Exception{
		System.out.println("Entrou no  método -------------------" + buscaSemantica);
		if(buscaSemantica == false) {
			System.out.println("Entrou no Simples");
			return simplesService.buscaSimples(keyword);
		}else if(buscaSemantica == true){
			//(Participante: “Leandro” )-[Requeriu]-(Processo)
			String parametroA = keyword.split(":")[1].split(")")[0];
			String parametroB = keyword.split("-[")[1].split("]-")[0];
			String parametroC = keyword.split("-(")[1].split(")")[0];
			return Graphservice.buscaSemantica(parametroA, parametroB,parametroC);
		}
		return null;
	}

	@GetMapping
	public String index () {
	    return "index";
	}
	
}