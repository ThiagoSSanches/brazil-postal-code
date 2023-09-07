package modelo;

import java.util.ArrayList;
import java.util.List;

public class AdicionaNaLista {
    private List<EnderecoViacep> enderecos = new ArrayList<>();
    public void guardaEndereco(EnderecoViacep address){
        enderecos.add(address);
    }

    public List<EnderecoViacep> getEnderecos() {
        return enderecos;
    }

    @Override
    public String toString() {
        return "(Lista de endereços: " +
                enderecos +
                ')';
    }
}
