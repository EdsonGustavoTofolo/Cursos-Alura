package br.com.alura.orcamento;

import br.com.alura.http.HttpAdapter;

public class RegistroDeOrcamento {

    private HttpAdapter http;

    public RegistroDeOrcamento(HttpAdapter http) {
        this.http = http;
    }

    public void registrar(Orcamento orcamento) {
        this.http.post("http://api.externa/orcamento", orcamento);
    }
}
