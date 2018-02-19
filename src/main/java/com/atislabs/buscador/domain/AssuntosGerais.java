package com.atislabs.buscador.domain;

import org.neo4j.ogm.annotation.Relationship;

public class AssuntosGerais extends Artefato{
	
	@Relationship(type = "EM", direction = Relationship.INCOMING)
	private Reuniao reuniao;


}
