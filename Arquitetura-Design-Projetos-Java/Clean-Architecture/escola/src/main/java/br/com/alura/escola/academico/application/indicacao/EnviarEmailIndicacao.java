package br.com.alura.escola.academico.application.indicacao;

import br.com.alura.escola.academico.domain.aluno.Aluno;

public interface EnviarEmailIndicacao {
    void enviarPara(Aluno indicado);
}
