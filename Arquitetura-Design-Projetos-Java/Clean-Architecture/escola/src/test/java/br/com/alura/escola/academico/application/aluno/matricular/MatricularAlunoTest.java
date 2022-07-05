package br.com.alura.escola.academico.application.aluno.matricular;

import br.com.alura.escola.shared.dominio.evento.PublicadorEventos;
import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.shared.dominio.Cpf;
import br.com.alura.escola.academico.infra.aluno.AlunoRepositoryInMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MatricularAlunoTest {

    @Test
    void deveSerPersistidoComSucesso() {
        var repository = new AlunoRepositoryInMemory();
        var publicadorEventos = new PublicadorEventos();
        var matricular = new MatricularAluno(repository, publicadorEventos);

        var dados = new MatricularAlunoDto("Edson", "email@gmail.com", "123.123.123-09");

        matricular.execute(dados);

        Aluno aluno = repository.buscarPorCpf(new Cpf("123.123.123-09"));

        assertNotNull(aluno);
        assertEquals("123.123.123-09", aluno.getCpf());
        assertEquals("email@gmail.com", aluno.getEmail());
        assertEquals("Edson", aluno.getNome());
    }
}