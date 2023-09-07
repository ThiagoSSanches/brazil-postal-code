package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeradorDeArquivo {
    public void salvaJson(EnderecoViacep endereco) throws IOException {
        List<EnderecoViacep> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter(endereco.cep() + ".json");
        escrita.write(gson.toJson(enderecos));
        escrita.close();
    }
}
