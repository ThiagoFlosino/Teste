package com.atislabs.buscador.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label = "Pessoa")
public class Pessoa extends Entidade{
	
	private String nome;
	
	@Relationship(type = "PARTICIPANTE", direction = Relationship.INCOMING)
	private Set<Reuniao> participantes = new HashSet<>();
	
	@Relationship(type = "AUSENTE", direction = Relationship.INCOMING)
	private Set<Reuniao> ausentes = new HashSet<>();

	
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, Set<Reuniao> participantes, Set<Reuniao> ausentes) {
		super();
		this.nome = nome;
		this.participantes = participantes;
		this.ausentes = ausentes;
	}

	public Set<Reuniao> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<Reuniao> participantes) {
		this.participantes = participantes;
	}

	public Set<Reuniao> getAusentes() {
		return ausentes;
	}

	public void setAusentes(Set<Reuniao> ausentes) {
		this.ausentes = ausentes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
