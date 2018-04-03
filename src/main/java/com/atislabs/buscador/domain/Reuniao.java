package com.atislabs.buscador.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.format.annotation.DateTimeFormat;


@NodeEntity(label = "Reuniao")
public class Reuniao {
	
	@GraphId 
	private Long id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date data; 
	private String nome;
	private Integer numeroReuniao;
	private Documento documento;
	
	@Relationship(type = "CITADO", direction = Relationship.INCOMING)
	private Set<Entidade> citados = new HashSet<>();
	
	@Relationship(type = "PERTENCE", direction = Relationship.OUTGOING)
	private Departamento departamento;
	
	
	@Relationship(type = "SECRETARIO", direction = Relationship.INCOMING)
	private Pessoa secretario;
	
	@Relationship(type = "PARTICIPANTE", direction = Relationship.INCOMING)
	private Set<Pessoa> participantes = new HashSet<>();
	
	@Relationship(type = "AUSENTE", direction = Relationship.INCOMING)
	private Set<Pessoa> ausentes = new HashSet<>();
	
	@Relationship(type = "CITADO_EM", direction = Relationship.INCOMING)
	private Set<Artefato> relacoes = new HashSet<>();
	
	@Relationship(type = "ABERTURA", direction = Relationship.INCOMING)
	private Set<Artefato> aberturas = new HashSet<>();
	
	@Relationship(type = "APROVADO", direction = Relationship.INCOMING)
	private Set<Artefato> aprovados = new HashSet<>();
	
	@Relationship(type = "REPROVADO", direction = Relationship.INCOMING)
	private Set<Artefato> reprovados = new HashSet<>();


	public Reuniao() {
		
	}
	
	public Reuniao(Long id, Date data, String nome, Integer numeroReuniao, Documento documento, Pessoa secretario,
			Set<Pessoa> participantes, Set<Pessoa> ausentes,Set<Artefato> relacoes, Departamento departamento) {
		super();
		this.id = id;
		this.data = data;
		this.nome = nome;
		this.numeroReuniao = numeroReuniao;
		this.documento = documento;
		this.secretario = secretario;
		this.participantes = participantes;
		this.relacoes = relacoes;
		this.departamento = departamento;
		this.ausentes = ausentes;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroReuniao() {
		return numeroReuniao;
	}

	public void setNumeroReuniao(Integer numeroReuniao) {
		this.numeroReuniao = numeroReuniao;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Pessoa getSecretario() {
		return secretario;
	}

	public void setSecretario(Pessoa secretario) {
		this.secretario = secretario;
	}

	public Set<Pessoa> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Pessoa participante) {
		this.participantes.add(participante);
	}

	public Set<Artefato> getRelacoes() {
		return relacoes;
	}

	public void setRelacoes(Artefato relacoes) {
		this.relacoes.add(relacoes);
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Set<Pessoa> getAusentes() {
		return ausentes;
	}

	public void setAusentes(Pessoa ausentes) {
		this.ausentes.add(ausentes);
	}
	
	public void setCitados(Entidade entidade) {
		this.citados.add(entidade);
	}
	
	public Set<Entidade> getCitados(){
		return this.citados;
	}

	
	

}
