package principal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.Endereco;
import modelo.EnderecoViacep;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Endereco>enderecos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")){

            System.out.println("Digite um CEP para busca ou sair para encerrar: ");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            String endereco = "https://viacep.com.br/ws/" + busca + "/json/";
            System.out.println(endereco);
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                EnderecoViacep meuEnderecoViacep = gson.fromJson(json, EnderecoViacep.class);
                System.out.println(meuEnderecoViacep);
                Endereco meuEndereco = new Endereco(meuEnderecoViacep);
                System.out.println("Endereço já convertido");
                System.out.println(meuEndereco);
                enderecos.add(meuEndereco);
            } catch (Exception e){
                System.out.println("erro");
                System.out.println(e.getMessage());
            }

        }
        System.out.println(enderecos);

        FileWriter escrita = new FileWriter("enderecos.json");
        escrita.write(gson.toJson(enderecos));
        escrita.close();
        System.out.println("O programa finalizou corretamente");

    }
}