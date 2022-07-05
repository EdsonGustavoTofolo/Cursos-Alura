package br.com.alura.desconto;

import br.com.alura.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoPorQuantidadeDeItens extends Desconto {

    public DescontoPorQuantidadeDeItens(Desconto proximo) {
        super(proximo);
    }

    @Override
    protected BigDecimal realizarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }

    @Override
    protected boolean deveCalcular(Orcamento orcamento) {
        return orcamento.getQuantidadeItens() > 5;
    }
}
