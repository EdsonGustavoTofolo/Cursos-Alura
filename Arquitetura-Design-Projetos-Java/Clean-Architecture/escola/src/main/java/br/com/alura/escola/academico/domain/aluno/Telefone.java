package br.com.alura.escola.academico.domain.aluno;

public class Telefone {

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }

    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) throws IllegalArgumentException {
        if (ddd == null || ddd.length() != 2) {
            throw new IllegalArgumentException("DDD invalido!");
        }
        if (numero == null || !numero.matches("^(?:[1-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$")) {
            throw new IllegalArgumentException("Numero invalido!");
        }
        this.ddd = ddd;
        this.numero = numero;
    }
}
