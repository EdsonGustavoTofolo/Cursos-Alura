package br.com.alura.desconto;

import br.com.alura.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeDescontos {

    /*
     * Padrão Chain of Responsibility aplicado encadeando as chamadas em cada classe de desconto.
     */
    public BigDecimal calcular(Orcamento orcamento) {
        var descontosEncadeados = new DescontoPorQuantidadeDeItens(
                new DescontoPorValor(
                        new SemDesconto()
                )
        );
        return descontosEncadeados.calcular(orcamento);
    }
}
