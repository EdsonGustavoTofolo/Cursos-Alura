package br.com.alura.desconto;

import br.com.alura.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class Desconto {

    protected Desconto proximo;

    public Desconto(Desconto proximo) {
        this.proximo = proximo;
    }

    /*
     * Padrão Template Method.
     * Abstrai a lógica para um método na classe mãe a qual utiliza métodos abstratos implementados nas classes filhas
     */
    public BigDecimal calcular(Orcamento orcamento) {
        if (deveCalcular(orcamento)) {
            return realizarCalculo(orcamento);
        }
        return proximo.calcular(orcamento);
    }

    protected abstract BigDecimal realizarCalculo(Orcamento orcamento);
    protected abstract boolean deveCalcular(Orcamento orcamento);
}
