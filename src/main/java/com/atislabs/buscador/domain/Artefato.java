package com.atislabs.buscador.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label = "Artefato")
public class Artefato extends Entidade {

	@GraphId
	private Long id;

	@Relationship(type = "CITADO_EM", direction = Relationship.INCOMING)
	private Set<Reuniao> citacoes = new HashSet<>();
	

	
	public Artefato() {
		
	}
	
	public Artefato(Set<Reuniao> citacoes, Reuniao abertura, Reuniao aprovado, Reuniao reprovado) {
		super();
		this.citacoes = citacoes;
	}

	public Set<Reuniao> getCitacoes() {
		return citacoes;
	}

	public void setCitacoes(Set<Reuniao> citacoes) {
		this.citacoes = citacoes;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	
}
