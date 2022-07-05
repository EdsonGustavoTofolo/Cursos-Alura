package br.com.alura;

import br.com.alura.imposto.CalculadoraDeImposto;
import br.com.alura.imposto.ICMS;
import br.com.alura.imposto.ISS;
import br.com.alura.orcamento.Orcamento;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        var orcamento = new Orcamento(new BigDecimal("100"));
        var calculadora = new CalculadoraDeImposto();

        System.out.println("ICMS: " + calculadora.calcular(orcamento, new ICMS()));
        System.out.println("ISS: " + calculadora.calcular(orcamento, new ISS()));
    }
}
