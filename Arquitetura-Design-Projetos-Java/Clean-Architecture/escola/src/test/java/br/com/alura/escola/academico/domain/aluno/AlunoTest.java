package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.shared.dominio.Cpf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    void setup() {
        this.aluno = new Aluno(new Cpf("123.123.123-09"), "Edson", new Email("edson@mgmail.com"));
    }

    @Test
    void devePermitirAdicionarTelefone() {
        aluno.adicionarTelefone("46", "99122-0909");

        assertNotNull(aluno.getTelefones());
        assertEquals(1, aluno.getTelefones().size());
        assertEquals("46", aluno.getTelefones().get(0).getDdd());
        assertEquals("99122-0909", aluno.getTelefones().get(0).getNumero());
    }

    @Test
    void naoDevePermitirAdicionarMaisDeDoisTelefones() {
        aluno.adicionarTelefone("46", "99122-0909");
        aluno.adicionarTelefone("46", "99122-0909");
        assertThrows(IllegalArgumentException.class, () -> aluno.adicionarTelefone("46", "99122-0909"));
    }
}