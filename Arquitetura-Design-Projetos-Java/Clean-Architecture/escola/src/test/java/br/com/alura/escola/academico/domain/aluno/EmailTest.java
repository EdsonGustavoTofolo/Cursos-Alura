package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.academico.domain.aluno.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void naoDeveriaCriarEmailsComEnderecosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("email invalido"));
    }

    @Test
    void deveCriarEmailComEnderecoValido() {
        var endereco = "cursoalura@gmail.com";
        var email = new Email(endereco);
        assertEquals(endereco, email.getEndereco());
    }
}