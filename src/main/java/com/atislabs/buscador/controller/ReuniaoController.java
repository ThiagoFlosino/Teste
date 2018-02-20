package com.atislabs.buscador.controller;

import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(path="/all")
	@GetMapping
	public Iterable<Reuniao> findAll() {
		return service.getReuniaoRepository().findAll();
	}

	@GetMapping
	public Reuniao findNumber() {
		return service.getReuniaoRepository().findByNumeroReuniao(10);
	}

	
	@PostMapping	
	public Reuniao create(@RequestBody Reuniao reuniao) {
		service.create(reuniao);
		
		return reuniao;
	
	}
	
}
