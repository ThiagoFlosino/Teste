package com.atislabs.buscador.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atislabs.buscador.domain.Reuniao;
import com.atislabs.buscador.repository.ReuniaoRepository;

@Service
public class GraphService {
	
	@Autowired private ReuniaoRepository reuniaoRepository;
	
	public ReuniaoRepository getReuniaoRepository() {
		return this.reuniaoRepository;
	}

	public Reuniao create(Reuniao reuniao) {
		reuniaoRepository.save(reuniao);
		return reuniao;
	}
	
	public void deleteNode(Long id) {
		reuniaoRepository.delete(id);
	}

	public List<Reuniao> buscaSemantica(String parametroA,String parametroB,String parametroC){
		return reuniaoRepository.buscaSemantica(parametroA, parametroB, parametroC);
	}
}
