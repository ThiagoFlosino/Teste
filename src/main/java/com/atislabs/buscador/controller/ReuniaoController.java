package com.atislabs.buscador.controller;

import java.util.Date;
import java.util.List;

import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atislabs.buscador.domain.Reuniao;
import com.atislabs.buscador.repository.service.GraphService;



//@EnableNeo4jRepositories

@Controller
@RestController
public class ReuniaoController {
	
	@Autowired private GraphService service;
	@Autowired private Session session;
	
/*	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody Reuniao getReuniao(@PathVariable Long id) {
		Optional<Reuniao> reuniao = service.getReuniaoRepository().findById(id);
		return reuniao.get();
	}*/
	
/*	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView redirect() {
		ModelAndView mv = new ModelAndView("index.html");
		return mv;	
	}
*/	
	
	public List<Reuniao> findAll() {
		return (List<Reuniao>) service.getReuniaoRepository().findAll();
	}

	@GetMapping
	public Reuniao findNumber() {
		return service.getReuniaoRepository().findByNumeroReuniao(10);
	}

	
	@PostMapping
	@ResponseBody
	public Reuniao create(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date data, @RequestParam String nome, @RequestParam String documento,
			@RequestParam Integer numero) {
		Reuniao reuniao = new Reuniao();
		reuniao.setData(data);
		reuniao.setNome(nome);
		reuniao.setDocumento(documento);
		reuniao.setNumeroReuniao(numero);
		
		service.create(reuniao);
		
		return reuniao;
	
	}
	
}
