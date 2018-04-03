package com.atislabs.buscador.domain;

public class Documento {
		private String nome;
		private String texto;
		
		public Documento(String nome, String texto) {
			this.nome = nome;
			this.texto = texto;
		}
		
		public Documento() {};
		public String getNome() {
			return this.nome;
		}
		
		public String getTexto() {
			return this.texto;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public void setTexto(String texto) {
			this.texto = texto;
		}
		
}
