import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
	public static void main(String[] args) throws Exception {
		
		//Fazer uma conexão http e buscar os 250 filmes
		// o que o navegador faz:

//		String url = "https://alura-imdb-api.herokuapp.com/movies";
//		ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
		
//		String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
//		ExtratorDeConteudo extrator =  new ExtratorDeConteudoDaNasa();
		
		String url = "http://localhost:8080/linguagens";
		ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

		var http = new ClienteHttp();
		String json = http.buscaDados(url);

		// exibir e manipular os dados
		List<Conteudo> conteudos = extrator.extraiConteudos(json);

		var geradora = new GeradorDeFigurinhas();

		for(int i=0; i < 4; i++) {

			Conteudo conteudo = conteudos.get(i);

			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo =  conteudo.getTitulo() + ".png";

			geradora.cria(inputStream, nomeArquivo);

			System.out.println(conteudo.getTitulo());
			System.out.println();
		}

	}
}