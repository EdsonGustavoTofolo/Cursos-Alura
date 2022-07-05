package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.TipoDeEvento;

/*
 * Ouvinte
 */
public class LogDeAlunoMatriculado extends Ouvinte {
    @Override
    protected void reageAo(Evento evento) {
        AlunoMatriculado event = (AlunoMatriculado) evento;
        System.out.println("Aluno matriculado com CPF " + event.getCpf() + " em " + event.momento());
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }
}
