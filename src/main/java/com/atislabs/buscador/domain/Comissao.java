package com.atislabs.buscador.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.Relationship;

public class Comissao extends Artefato{
	
	private Date dataCriacao;
	private Date dataTermino;
	private String funcao;

	
	@Relationship(type = "ABERTURA", direction = Relationship.INCOMING)
	private Reuniao abertura;
	
	@Relationship(type = "MEMBRO", direction = Relationship.INCOMING)
	private Set<Professor> membrosProfessor = new HashSet<>();
	
	@Relationship(type = "MEMBRO", direction = Relationship.INCOMING)
	private Set<Aluno> membrosAluno = new HashSet<>();

	@Relationship(type = "MEMBRO", direction = Relationship.INCOMING)
	private Set<Tecnico> membrosTecnico = new HashSet<>();

	
	@Relationship(type = "PRESIDENTE", direction = Relationship.INCOMING)
	private Set<Professor> presidenteProfessor = new HashSet<>();

	@Relationship(type = "PRESIDENTE", direction = Relationship.INCOMING)
	private Set<Tecnico> presidenteTecnico = new HashSet<>();

	
	public Comissao() {
		
	}
	
	
	public Comissao(Date dataCriacao, Date dataTermino, Reuniao abertura, Set<Professor> membrosProfessor,
			Set<Aluno> membrosAluno, Set<Tecnico> membrosTecnico, Set<Professor> presidenteProfessor,
			Set<Tecnico> presidenteTecnico) {
		super();
		this.dataCriacao = dataCriacao;
		this.dataTermino = dataTermino;
		this.abertura = abertura;
		this.membrosProfessor = membrosProfessor;
		this.membrosAluno = membrosAluno;
		this.membrosTecnico = membrosTecnico;
		this.presidenteProfessor = presidenteProfessor;
		this.presidenteTecnico = presidenteTecnico;
	}


	public Date getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public Date getDataTermino() {
		return dataTermino;
	}


	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}


	public Reuniao getAbertura() {
		return abertura;
	}


	public void setAbertura(Reuniao abertura) {
		this.abertura = abertura;
	}


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


	public Set<Professor> getPresidenteProfessor() {
		return presidenteProfessor;
	}


	public void setPresidenteProfessor(Set<Professor> presidenteProfessor) {
		this.presidenteProfessor = presidenteProfessor;
	}


	public Set<Tecnico> getPresidenteTecnico() {
		return presidenteTecnico;
	}


	public void setPresidenteTecnico(Set<Tecnico> presidenteTecnico) {
		this.presidenteTecnico = presidenteTecnico;
	}


	public String getFuncao() {
		return funcao;
	}


	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	
	
	
	
}
