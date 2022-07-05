package br.com.alura.escola.academico.domain.aluno;

public interface CifradorSenha {

    String cifrar(String senha);
    boolean validarSenha(String senhaCifrada, String senha);

}
