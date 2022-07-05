package br.com.alura.imposto;

import br.com.alura.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class Imposto {

    private Imposto outro;

    public Imposto(Imposto outro) {
        this.outro = outro;
    }

    public BigDecimal calcular(Orcamento orcamento) {
        var valorImposto = realizarCalculo(orcamento);
        var valorOutroImposto = BigDecimal.ZERO;
        if (outro != null) {
            valorOutroImposto = outro.calcular(orcamento);
        }
        return valorImposto.add(valorOutroImposto);
    }

    protected abstract BigDecimal realizarCalculo(Orcamento orcamento);
}
