package com.testejson.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TestejsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestejsonApplication.class, args);
		
					
			String texto = "{ \"nome\": \"Fulano\", \"idade\": 90, \"filmes_preferidos\": [ \"Pulp Fiction\", \"Clube da Luta\" ],"
					+ " \"contatos\": { \"telefone\": \"(11) 91111-2222\", \"emails\": [ \"fulano@gmail.com\", \"fulano@yahoo.com\" ]  } }";
	// cria o JSONObject
			JSONObject obj = new JSONObject(texto);
	// verifica se possui a chave "nome"
			if (obj.has("nome")) {
				System.out.println("possui nome=" + obj.getString("nome")); // nome é uma String
			} else {
				System.out.println("não possui nome");
			}
	// obtém o array de filmes 
			JSONArray filmes = obj.getJSONArray("filmes_preferidos");
			filmes.forEach(System.out::println); // imprime todos os filmes
	// obtém o objeto com os contatos
			JSONObject contatos = obj.getJSONObject("contatos");
			for (String chave : contatos.keySet()) {
				System.out.println(chave + "=" + contatos.get(chave));
			}
	//----------------------------------------------------------
	// adicionar mais um contato
			contatos.put("twitter", "@fulano");
	// imprime o JSON formatado (indentando com 2 espaços)
			System.out.println(obj.toString(2));
			

		
	}

}
