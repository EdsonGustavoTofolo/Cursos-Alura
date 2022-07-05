package br.com.alura.imposto;

import br.com.alura.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeImposto {
    /*
     * Padrão Strategy sendo aplicado quando trocamos as várias condições por classes que implementam suas regras e estratégias.
     * Evitamos assim o uso de "ifs" ou "switch", aplicamos o SRP (Single Responsibility Principle),
     * OCP (Open Closed Principle) e o DIP (Dependency Inversion Principle).
     * Também aumentamos a coesão do código e diminuimos o acoplamento ao passar a interface Imposto como parâmetro.
     * Este padrão requer que as condições ocorram através de um valor único e conhecido como o parâmetro Imposto.
     */
    public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
        return imposto.calcular(orcamento);
    }
}
