package com.atislabs.buscador.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity(label = "Entidade")
public abstract class Entidade {
		
	@Id @GeneratedValue
	private Long graphId;

	private Long id;
	
	private String posicao;
	
	private String trecho;
	
	private Integer numeroCitacoes;
	
	private Integer numeroRelacoes;

	public Entidade() {
		
	}
	
	public Entidade(Long id, String posicao, String trecho, Integer numeroCitacoes, Integer numeroRelacoes) {
		super();
		this.id = id;
		this.posicao = posicao;
		this.trecho = trecho;
		this.numeroCitacoes = numeroCitacoes;
		this.numeroRelacoes = numeroRelacoes;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPosicao() {
		return posicao;
	}
	
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	public String getTrecho() {
		return trecho;
	}
	
	public void setTrecho(String trecho) {
		this.trecho = trecho;
	}
	
	public Integer getNumeroCitacoes() {
		return numeroCitacoes;
	}
	
	public void setNumeroCitacoes(Integer numeroCitacoes) {
		this.numeroCitacoes = numeroCitacoes;
	}
	
	public Integer getNumeroRelacoes() {
		return numeroRelacoes;
	}
	
	public void setNumeroRelacoes(Integer numeroRelacoes) {
		this.numeroRelacoes = numeroRelacoes;
	}


}
