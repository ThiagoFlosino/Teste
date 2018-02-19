package com.atislabs.buscador.repository;


import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atislabs.buscador.domain.Reuniao;

@Repository
public interface ReuniaoRepository extends  Neo4jRepository<Reuniao, Long>{
		
	
		public Optional<Reuniao> findById(Long Id);
	
	
		public Reuniao findByNome(@Param("nome") String nome);
		public Reuniao findByNumeroReuniao(@Param("numReuniao") Integer numReuniao);
}