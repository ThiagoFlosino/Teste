package com.atislabs.buscador.repository.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.atislabs.buscador.configuration.CONSTANTS;
import com.atislabs.buscador.configuration.Indexer;
import com.atislabs.buscador.domain.Documento;
import com.atislabs.buscador.domain.Reuniao;
import com.atislabs.buscador.exceptions.FileExceptions;

@Service
public class BuscaSimplesService {

	private static String caminhoPrefixo = CONSTANTS.FILES_PATH;
	
	
	
	public static String lerArquivo(String caminho) throws FileExceptions {
		String nomeArquivo = caminho;
		String texto = "";
		try {
			FileReader arq = new FileReader(nomeArquivo);
			BufferedReader lerArq = new BufferedReader(arq);
 
			String linha = lerArq.readLine();

			while (linha != null) {
				texto += "\n" + linha; 
				linha = lerArq.readLine();
			}

			arq.close();
		} catch (Exception e) {
			throw new FileExceptions();
		}
		return texto;
	}

	public File[] listarArquivos() {	
		File AbsolutePath = new File("").getAbsoluteFile();
		File atas = new File(AbsolutePath.getAbsoluteFile()+caminhoPrefixo);//caminhoPrefixo);
		File[] arquivos =  atas.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				if(pathname.getName().contains(".txt")) {
					return true;
				}
				return false;
			}
		});
		return arquivos;
	}
	
	public static File[] concat(File[] a, File[] b) {
		   int aLen = a.length;
		   int bLen = b.length;
		   File[] c= new File[aLen+bLen];
		   System.arraycopy(a, 0, c, 0, aLen);
		   System.arraycopy(b, 0, c, aLen, bLen);
		   return c;
		}
	
	public List<Reuniao> buscaSimples(String keyword) throws Exception{
		
		ArrayList<Reuniao> reunioes = new ArrayList<>();
		ArrayList<Reuniao> documentosEncontrados = new ArrayList<>();

		File[] nomesDocumentos = listarArquivos();
		ArrayList<Reuniao> resultados = new ArrayList<>();
		Map<String, Reuniao> mapa = new HashMap<String, Reuniao>();
		keyword = keyword.replaceAll("\"", "").replaceAll("“", "").replaceAll("”", "").replaceAll("'", "");
		String[] palavras = keyword.split(" ");
		
		System.out.println("----------->>>>>>" + keyword);
		for (int i = 0; i < nomesDocumentos.length; i++) {
			Reuniao reuniao = new Reuniao();
			Documento documento = new Documento(); 
			String nome = nomesDocumentos[i].getPath().split("atas")[1].replaceAll("[\\/]|[\\\\]", "");
			documento.setNome("/"+nome);
			documento.setTexto(lerArquivo(nomesDocumentos[i].getPath()));    //.getParent().split("atas")[1] + nomesDocumentos[i].getName()));
			reuniao.setDocumento(documento);
			reunioes.add(reuniao);
		}
		Indexer indexer = new Indexer();
		indexer.fillListDocumentsFound(keyword, reunioes, documentosEncontrados);

		for (Reuniao d : documentosEncontrados) {
								
			if(!mapa.containsKey(d.getDocumento().getNome())){ mapa.put(d.getDocumento().getNome(),d); }
					
		}
		
		resultados.addAll(mapa.values());
		return resultados;
	}

	
	
}
