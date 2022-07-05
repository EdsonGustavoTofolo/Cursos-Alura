package br.com.alura.orcamento;

import java.math.BigDecimal;

public class Item implements Orcavel {
    private BigDecimal valor;

    public Item(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }
}
