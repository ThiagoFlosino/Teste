package com.atislabs.buscador.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.Relationship;

public class Processo extends Artefato{

	private String tipo;
	private String numeroProcesso;
	
	
	@Relationship(type = "ABERTURA", direction = Relationship.INCOMING)
	private Reuniao abertura;
	
	@Relationship(type = "APROVADO", direction = Relationship.INCOMING)
	private Reuniao aprovado;
	
	@Relationship(type = "REPROVADO", direction = Relationship.INCOMING)
	private Reuniao reprovado;
	
	@Relationship(type = "REQUERIU", direction = Relationship.INCOMING)
	private Set<Professor> requerimentosProfessor = new HashSet<>();
	
	@Relationship(type = "REQUERIU", direction = Relationship.INCOMING)
	private Set<Aluno> requerimentosAluno = new HashSet<>();
	
	@Relationship(type = "REQUERIU", direction = Relationship.INCOMING)
	private Set<Tecnico> requerimentosTecnico = new HashSet<>();
	
	
	public Processo() {
		
	}
	
	
	
	public Processo(String tipo, Reuniao abertura, Reuniao aprovado, Reuniao reprovado, String numProcesso) {
		super();
		this.tipo = tipo;
		this.abertura = abertura;
		this.aprovado = aprovado;
		this.reprovado = reprovado;
		this.numeroProcesso = numProcesso;
	}



	public Reuniao getAbertura() {
		return abertura;
	}

	public void setAbertura(Reuniao abertura) {
		this.abertura = abertura;
	}

	public Reuniao getAprovado() {
		return aprovado;
	}

	public void setAprovado(Reuniao aprovado) {
		this.aprovado = aprovado;
	}

	public Reuniao getReprovado() {
		return reprovado;
	}

	public void setReprovado(Reuniao reprovado) {
		this.reprovado = reprovado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getNumeroProcesso() {
		return numeroProcesso;
	}



	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}
	
	
}
