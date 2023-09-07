package principal;

import modelo.ConsultaCep;
import modelo.EnderecoViacep;
import modelo.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        ConsultaCep consultaCep = new ConsultaCep();
        EnderecoViacep novoEndereco = null;

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite um CEP para busca ou sair para encerrar: ");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                novoEndereco = consultaCep.buscaEndereco(busca);
                System.out.println(novoEndereco);

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando a aplicação");
            }
        }
        GeradorDeArquivo gerador = new GeradorDeArquivo();
        gerador.salvaJson(novoEndereco);

    }
}