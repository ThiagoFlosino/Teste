package com.atislabs.buscador.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ComponentScan("com.atislabs.buscador")
@EnableNeo4jRepositories("com.atislabs.buscador.repository")
public class Configuration {

}

	

