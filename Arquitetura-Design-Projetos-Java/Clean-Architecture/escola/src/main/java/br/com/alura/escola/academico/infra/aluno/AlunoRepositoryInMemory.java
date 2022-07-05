package br.com.alura.escola.academico.infra.aluno;

import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.academico.domain.aluno.AlunoRepository;
import br.com.alura.escola.shared.dominio.Cpf;

import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryInMemory implements AlunoRepository {

    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCpf(Cpf cpf) {
        return this.matriculados.stream().filter(aluno -> aluno.getCpf().equals(cpf.getNumero())).findFirst().orElse(null);
    }

    @Override
    public List<Aluno> buscarTodosAlunosMatriculados() {
        return this.matriculados;
    }
}
