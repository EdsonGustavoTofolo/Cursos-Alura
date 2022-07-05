package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.shared.dominio.Cpf;

public class AlunoFactory {

    private Aluno aluno;

    public AlunoFactory comNomeCpfEmail(String nome, String cpf, String email) {
        this.aluno = new Aluno(new Cpf(cpf), nome, new Email(email));
        return this;
    }

    public AlunoFactory comTelefone(String ddd, String numero) {
        this.aluno.adicionarTelefone(ddd, numero);
        return this;
    }

    public Aluno criar() {
        return this.aluno;
    }
}
