package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeradorDeArquivo {
    public void salvaJson(AdicionaNaLista endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter("enderecos.json");
        escrita.write(gson.toJson(endereco.getEnderecos()));
        escrita.close();
    }
}
