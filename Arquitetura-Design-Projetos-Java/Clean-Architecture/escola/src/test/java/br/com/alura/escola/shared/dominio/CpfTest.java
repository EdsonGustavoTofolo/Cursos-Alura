package br.com.alura.escola.shared.dominio;

import br.com.alura.escola.shared.dominio.Cpf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfTest {

    @Test
    void naoDeveriaCriarCpfInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Cpf(""));
        assertThrows(IllegalArgumentException.class, () -> new Cpf(null));
        assertThrows(IllegalArgumentException.class, () -> new Cpf("123455"));
        assertThrows(IllegalArgumentException.class, () -> new Cpf("12345678909"));
    }

    @Test
    void deveCriarCpfComNumeroValido() {
        var numero = "123.456.789-09";
        var cpf = new Cpf(numero);
        assertEquals(numero, cpf.getNumero());
    }
}