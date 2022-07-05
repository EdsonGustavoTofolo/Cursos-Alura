package br.com.alura.escola.academico.domain.aluno;

/*
 * Classe Email é considerado um Value Object pois só serve para encapsular um valor, não havendo
 * diferenciação de instancias.
 */
public class Email {

    public String getEndereco() {
        return endereco;
    }

    private String endereco;

    public Email(String endereco) {
        if (endereco == null || !endereco.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
            throw new IllegalArgumentException("E-mail invalido!");
        }
       this.endereco = endereco;
    }
}
