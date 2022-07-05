package br.com.alura.escola.shared.dominio;

import java.util.Objects;

public class Cpf {

    public String getNumero() {
        return numero;
    }

    private String numero;

    public Cpf(String numero) {
        if (numero == null || !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("CPF invalido!");
        }
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cpf cpf = (Cpf) o;

        return Objects.equals(numero, cpf.numero);
    }

    @Override
    public int hashCode() {
        return numero != null ? numero.hashCode() : 0;
    }
}
