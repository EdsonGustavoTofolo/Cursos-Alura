package br.com.alura.escola.academico.infra.aluno;

import br.com.alura.escola.academico.domain.aluno.CifradorSenha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CifradorSenhaMD5 implements CifradorSenha {

    @Override
    public String cifrar(String senha) {
        try {
            var md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            var bytes = md.digest();
            var sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append((bytes[i] & 0xff) + 0x100);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean validarSenha(String senhaCifrada, String senha) {
        return this.cifrar(senha).equals(senhaCifrada);
    }
}
