import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class App {
    public static void main(String[] args) throws Exception {
        //Fazer uma conexão http e buscar os 250 filmes
        // o que o navegador faz:
        String url = "https://alura-imdb-api.herokuapp.com/movies";
        URI endereco = URI.create(url);
        var client =  HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        //System.out.println(body);


        //Pegar os dados que interessam (titulo, poster, classificação)
        // parsear - separar
//        var parser = new JsonParser();
//        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        //System.out.println(listaDeFilmes.size());
        //System.out.println(listaDeFilmes.get(0));
        
        Gson gson = new Gson();
       
        Type tipoLista = new TypeToken<ArrayList<String>>() {}.getType();
        List<Map<String, String>> listaDeFilmes = gson.fromJson(body, tipoLista);
		for(Map<String, String> item : listaDeFilmes)
		{
			System.out.println(item);
		}

        // exibir e manipular os dados
//        for (Map<String,String> filme : listaDeFilmes) {
//            System.out.println(filme.get("title"));
//            System.out.println(filme.get("image"));
//            System.out.println(filme.get("imDbRating"));
//            System.out.println();
//        }
    }
}