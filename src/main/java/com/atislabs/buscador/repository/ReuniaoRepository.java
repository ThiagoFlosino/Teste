package com.atislabs.buscador.repository;


import java.util.Optional;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.atislabs.buscador.domain.Reuniao;

@Repository
public interface ReuniaoRepository extends Neo4jRepository<Reuniao, Long>{
		
	
		public Optional<Reuniao> findById(Long Id);
	
	
		public Reuniao findByNome(String nome);
		public Reuniao findByNumeroReuniao(Integer numeroReuniao);
		
		@Query("MATCH (r:Reuniao)-[:CITADO]-(p:Processo)-[:Requeriu]-(e:Entidade {trecho = {0}}) RETURN *")
		public Reuniao buscaProcessosRequeridosPorPessoa(String nomePessoa);
}
