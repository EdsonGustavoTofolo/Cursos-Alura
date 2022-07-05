package br.com.alura.escola.academico.application.aluno.matricular;

import br.com.alura.escola.academico.domain.aluno.AlunoRepository;
import br.com.alura.escola.shared.dominio.Cpf;
import br.com.alura.escola.shared.dominio.evento.PublicadorEventos;
import br.com.alura.escola.academico.domain.aluno.AlunoMatriculado;

public class MatricularAluno {

    private final AlunoRepository alunoRepository;
    private final PublicadorEventos publicadorEventos;

    public MatricularAluno(AlunoRepository alunoRepository, PublicadorEventos publicadorEventos) {
        this.alunoRepository = alunoRepository;
        this.publicadorEventos = publicadorEventos;
    }

    // Padrão de Projeto "Command"
    public void execute(MatricularAlunoDto dados) {
        var aluno = dados.criarAluno();
        this.alunoRepository.matricular(aluno);

        this.publicadorEventos.publicar(new AlunoMatriculado(new Cpf(aluno.getCpf())));
    }
}
