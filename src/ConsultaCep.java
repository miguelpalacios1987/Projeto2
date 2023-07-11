import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static java.net.http.HttpClient.newHttpClient;

public class ConsultaCep {

    public Endereco buscaEndereco(String cep)  {


        URI endereco = URI.create("https://viacep.com.br/ws/" +cep+"/json");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);
        }catch (Exception e){
            throw new RuntimeException("Não consegui faze apartir de ese cep");
        }


    }

}
