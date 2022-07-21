import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.Key;
import java.util.List;
import java.util.Map;

public class App {

    private static String key;

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os filmes
        String url = "https://api.themoviedb.org/3/movie/550?api_key=7b4c22a6e2407b6b1d1523351e31c484";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
       
        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        // exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get(key:"original title"));
        }
    }

}
