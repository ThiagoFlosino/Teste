package com.atislabs.buscador.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.Relationship;

public class Departamento extends Artefato {
	
	private String nome;
	
	@Relationship(type = "MEMBRO", direction = Relationship.INCOMING)
	private Set<Professor> membrosProfessor = new HashSet<>();
	
	@Relationship(type = "MEMBRO", direction = Relationship.INCOMING)
	private Set<Aluno> membrosAluno = new HashSet<>();

	@Relationship(type = "MEMBRO", direction = Relationship.INCOMING)
	private Set<Tecnico> membrosTecnico = new HashSet<>();

	public Set<Professor> getMembrosProfessor() {
		return membrosProfessor;
	}

	public void setMembrosProfessor(Set<Professor> membrosProfessor) {
		this.membrosProfessor = membrosProfessor;
	}

	public Set<Aluno> getMembrosAluno() {
		return membrosAluno;
	}

	public void setMembrosAluno(Set<Aluno> membrosAluno) {
		this.membrosAluno = membrosAluno;
	}

	public Set<Tecnico> getMembrosTecnico() {
		return membrosTecnico;
	}

	public void setMembrosTecnico(Set<Tecnico> membrosTecnico) {
		this.membrosTecnico = membrosTecnico;
	}

	
	public Departamento() {
		
	}
	public Departamento(Set<Professor> membrosProfessor, Set<Aluno> membrosAluno, Set<Tecnico> membrosTecnico) {
		super();
		this.membrosProfessor = membrosProfessor;
		this.membrosAluno = membrosAluno;
		this.membrosTecnico = membrosTecnico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	

}
