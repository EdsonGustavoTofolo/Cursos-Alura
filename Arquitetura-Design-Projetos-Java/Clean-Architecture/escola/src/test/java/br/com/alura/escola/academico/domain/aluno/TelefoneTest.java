package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.academico.domain.aluno.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TelefoneTest {

    @Test
    void naoDeveriaCriarTelefoneComDddInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("123", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("1", null));
    }

    @Test
    void naoDeveriaCriarTelefoneComNumeroInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone("46", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("46", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("46", "123"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("46", "12341234"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("46", "991021234"));
    }

    @Test
    void deveCriarTelefoneComDddEnumeroValido() {
        var ddd = "46";
        var numero = "99102-9999";
        var telefone = new Telefone(ddd, numero);
        assertEquals(ddd, telefone.getDdd());
        assertEquals(numero, telefone.getNumero());
    }

}