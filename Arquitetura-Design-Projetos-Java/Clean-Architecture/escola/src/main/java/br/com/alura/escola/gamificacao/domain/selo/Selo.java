package br.com.alura.escola.gamificacao.domain.selo;

import br.com.alura.escola.shared.dominio.Cpf;

public class Selo {

    private Cpf cpfAluno;
    private String nome;

    public Selo(Cpf cpfAluno, String nome) {
        this.cpfAluno = cpfAluno;
        this.nome = nome;
    }

    public String getCpfAluno() {
        return cpfAluno.getNumero();
    }

    public String getNome() {
        return nome;
    }
}
