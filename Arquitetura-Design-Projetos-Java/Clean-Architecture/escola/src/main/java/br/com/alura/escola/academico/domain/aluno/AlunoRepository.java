package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.shared.dominio.Cpf;

import java.util.List;

public interface AlunoRepository {
    void matricular(Aluno aluno);
    Aluno buscarPorCpf(Cpf cpf);
    List<Aluno> buscarTodosAlunosMatriculados();
}
