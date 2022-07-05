package br.com.alura;

import br.com.alura.desconto.CalculadoraDeDescontos;
import br.com.alura.orcamento.Orcamento;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        var calculadora = new CalculadoraDeDescontos();

        var orcamento1 = new Orcamento(new BigDecimal("200"), 6);
        var orcamento2 = new Orcamento(new BigDecimal("1000"), 1);

        System.out.println("Desconto por quantidade de itens: " + calculadora.calcular(orcamento1));
        System.out.println("Desconto por valor: " + calculadora.calcular(orcamento2));
    }
}
