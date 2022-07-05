package br.com.alura.orcamento;

import br.com.alura.orcamento.situacao.EmAnalise;
import br.com.alura.orcamento.situacao.Situacao;

import java.math.BigDecimal;

/*
 * Padrão State é aplicado quando a chamada de um método depende do estado do objeto,
 * como é o caso do método "aplicarDescontoExtra", cada situação irá ter suas próprias regras
 * onde a classe mãe é implementada para ser uma "casca" para cada classe filha
 */
public class Orcamento {
    private BigDecimal valor;
    private int quantidadeItens;
    private Situacao situacao;

    public Orcamento(BigDecimal valor, int quantidadeItens) {
        this.valor = valor;
        this.quantidadeItens = quantidadeItens;
        this.situacao = new EmAnalise();
    }

    public void aplicarDescontoExtra() {
        var valorDoDescontoExtra = this.situacao.calcularValorDescontoExtra(this);
        this.valor = this.valor.subtract(valorDoDescontoExtra);
    }

    public void aprovar() {
        this.situacao.aprovar(this);
    }

    public void reprovar() {
        this.situacao.reprovar(this);
    }

    public void finalizar() {
        this.situacao.finalizar(this);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
}
