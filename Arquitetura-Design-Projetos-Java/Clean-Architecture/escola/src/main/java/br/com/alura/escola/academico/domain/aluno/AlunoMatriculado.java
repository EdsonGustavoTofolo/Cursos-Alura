package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.Cpf;
import br.com.alura.escola.shared.dominio.evento.TipoDeEvento;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

/*
 * Evento de Dominio
 */
public class AlunoMatriculado implements Evento {
    private final Cpf cpf;
    private final LocalDateTime momento;

    public AlunoMatriculado(Cpf cpf) {
        this.cpf = cpf;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }

    @Override
    public TipoDeEvento tipo() {
        return TipoDeEvento.ALUNO_MATRICULADO;
    }

    @Override
    public Map<String, Object> informacoes() {
        return Collections.singletonMap("cpf", cpf);
    }

    public Cpf getCpf() {
        return cpf;
    }
}
