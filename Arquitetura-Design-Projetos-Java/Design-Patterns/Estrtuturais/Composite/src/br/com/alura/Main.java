package br.com.alura;

import br.com.alura.orcamento.Item;
import br.com.alura.orcamento.Orcamento;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        var orcamentoAntigo = new Orcamento();
        orcamentoAntigo.addItem(new Item(new BigDecimal("200")));

        var orcamentoNovo = new Orcamento();
        orcamentoNovo.addItem(new Item(new BigDecimal("500")));
        orcamentoNovo.addItem(orcamentoAntigo);

        System.out.println(orcamentoNovo.getValor());
    }
}
