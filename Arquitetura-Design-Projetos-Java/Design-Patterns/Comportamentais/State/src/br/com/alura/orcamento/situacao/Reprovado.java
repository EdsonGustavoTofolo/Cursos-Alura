package br.com.alura.orcamento.situacao;

import br.com.alura.orcamento.Orcamento;

public class Reprovado extends Situacao {

    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }

}
