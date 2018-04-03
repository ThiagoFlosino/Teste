package com.atislabs.buscador.configuration;


import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocsCollector;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import com.atislabs.buscador.domain.Documento;
import com.atislabs.buscador.domain.Reuniao;



public class Indexer {
	
	//public static void main(String[] args){
		
	public void fillListDocumentsFound(String palavrasChave, ArrayList<Reuniao> documentos, ArrayList<Reuniao> documentosEncontrados) throws Exception{		
	
			
			StandardAnalyzer analyzer = new StandardAnalyzer();  
			  
			// Diretório virtual para o índice  
			Directory indexDirectory = new RAMDirectory();  
			   
			// Cria o arquivo com tamanho ilimitado.  
			IndexWriterConfig config = new IndexWriterConfig(analyzer);
			IndexWriter iw = new IndexWriter(indexDirectory,config);
//					MaxFieldLength.UNLIMITED);  
			  
			// Adiciona os documentos.  
			for(Reuniao d : documentos){
				addDoc(iw, d.getDocumento().getNome(), d.getDocumento().getTexto());
			}
			  
			// Fecha o arquivo.  
			iw.close();  
			
			// Cria a query
			Query q = new QueryParser("texto", analyzer).parse(palavrasChave);   
			  
			// Cria o acesso ao índice  
			IndexReader reader = DirectoryReader.open(indexDirectory);
			IndexSearcher searcher = new IndexSearcher(reader);  
			  
			// Prepara a coleção de resultado  
			TopDocsCollector collector = TopScoreDocCollector.create(20);
			// Faz a pesquisa  
			searcher.search(q, collector);  
			  
			// Separa os itens mais relevantes para a consulta.  
			ScoreDoc[] hits = collector.topDocs().scoreDocs;  
			
			System.out.println("Found " + hits.length + " hits.");  
			for (int i = 0; i < hits.length; ++i) {  
			    int docId = hits[i].doc;  
			    Document d = searcher.doc(docId);
			    Reuniao reuniao = new Reuniao();
				Documento documento = new Documento();
				documento.setNome(d.get("nome"));
				documento.setTexto(d.get("texto"));
				reuniao.setDocumento(documento);
			    documentosEncontrados.add(reuniao);
			    System.out.println((i + 1) + ". " +d.get("nome"));  
			}
	}
	
	private static void addDoc(IndexWriter iw, String nome, String texto) throws IOException {  
	    Document doc = new Document();  
	    doc.add(new TextField("nome", nome, Store.YES));
	    doc.add(new TextField("texto", texto, Store.YES));
	    
	    iw.addDocument(doc);  
	}  
	

}