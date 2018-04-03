package com.atislabs.buscador.exceptions;

@SuppressWarnings("serial")
public class FileExceptions extends Exception{
			
	public String toString() {
		return "Houve um erro na abertura do arquivo.";
	}
	
	@Override
	public String getMessage() {
		return "Houve um erro na abertura do arquivo.";
	}

}
