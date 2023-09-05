package modelo;

public class Endereco {
    private String rua;
    private String cep;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public String getRua() {
        return rua;
    }

    public String getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public Endereco(EnderecoViacep meuEnderecoViacep) {
        this.cep = meuEnderecoViacep.cep();
        this.complemento = meuEnderecoViacep.complemento();
        this.bairro = meuEnderecoViacep.bairro();
        this.rua = meuEnderecoViacep.logradouro();
        this.cidade = meuEnderecoViacep.localidade();
        this.estado = meuEnderecoViacep.uf();
    }

    @Override
    public String toString() {
        return "(Endereco: " +
                "Rua: " + rua + '\'' +
                ", CEP: " + cep +
                ", Complemento: " + complemento + '\'' +
                ", Bairro: " + bairro + '\'' +
                ", Cidade: " + cidade + '\'' +
                ", Estado: " + estado + '\'' +
                ')';
    }
}
