package br.com.alura.desconto;

import br.com.alura.orcamento.Orcamento;

import java.math.BigDecimal;

public class SemDesconto extends Desconto {


    public SemDesconto() {
        super(null);
    }

    @Override
    protected BigDecimal realizarCalculo(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }

    @Override
    protected boolean deveCalcular(Orcamento orcamento) {
        return true;
    }
}
