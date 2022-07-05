package br.com.alura.escola.academico.application.aluno.matricular;

import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.shared.dominio.Cpf;
import br.com.alura.escola.academico.domain.aluno.Email;

public class MatricularAlunoDto {
    private String nome;
    private String email;
    private String cpf;

    public MatricularAlunoDto(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public Aluno criarAluno() {
        return new Aluno(new Cpf(this.cpf), this.nome, new Email(this.email));
    }
}
