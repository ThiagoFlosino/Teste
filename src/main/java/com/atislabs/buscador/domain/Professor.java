package com.atislabs.buscador.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label = "Professor")
public class Professor extends Pessoa{
	
	@Relationship(type = "SECRETARIO", direction = Relationship.INCOMING)
	private Set<Reuniao> secretario = new HashSet<>();
	
	@Relationship(type = "REQUERIU", direction = Relationship.INCOMING)
	private Set<Processo> requerimentos = new HashSet<>();
	
	@Relationship(type = "PRESIDENTE", direction = Relationship.INCOMING)
	private Set<Comissao> presideComissao = new HashSet<>();
	
	@Relationship(type = "PRESIDENTE", direction = Relationship.INCOMING)
	private Set<Banca> presideBanca = new HashSet<>();
	
	
	@Relationship(type = "MEMBRO", direction = Relationship.INCOMING)
	private Set<Comissao> membroComissao = new HashSet<>();
	
	@Relationship(type = "MEMBRO", direction = Relationship.INCOMING)
	private Set<Banca> membroBanca = new HashSet<>();
	
	@Relationship(type = "MEMBRO", direction = Relationship.INCOMING)
	private Departamento departamento;
	
	public Professor() {
		
	}

	public Professor(Set<Reuniao> secretario, Set<Processo> requerimentos, Set<Comissao> presideComissao,
			Set<Banca> presideBanca, Set<Comissao> membroComissao, Set<Banca> membroBanca, Departamento departamento) {
		super();
		this.secretario = secretario;
		this.requerimentos = requerimentos;
		this.presideComissao = presideComissao;
		this.presideBanca = presideBanca;
		this.membroComissao = membroComissao;
		this.membroBanca = membroBanca;
		this.departamento = departamento;
	}

	public Set<Reuniao> getSecretario() {
		return secretario;
	}

	public void setSecretario(Set<Reuniao> secretario) {
		this.secretario = secretario;
	}

	public Set<Processo> getRequerimentos() {
		return requerimentos;
	}

	public void setRequerimentos(Set<Processo> requerimentos) {
		this.requerimentos = requerimentos;
	}

	public Set<Comissao> getPresideComissao() {
		return presideComissao;
	}

	public void setPresideComissao(Set<Comissao> presideComissao) {
		this.presideComissao = presideComissao;
	}

	public Set<Banca> getPresideBanca() {
		return presideBanca;
	}

	public void setPresideBanca(Set<Banca> presideBanca) {
		this.presideBanca = presideBanca;
	}

	public Set<Comissao> getMembroComissao() {
		return membroComissao;
	}

	public void setMembroComissao(Set<Comissao> membroComissao) {
		this.membroComissao = membroComissao;
	}

	public Set<Banca> getMembroBanca() {
		return membroBanca;
	}

	public void setMembroBanca(Set<Banca> membroBanca) {
		this.membroBanca = membroBanca;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	
	
	
}
