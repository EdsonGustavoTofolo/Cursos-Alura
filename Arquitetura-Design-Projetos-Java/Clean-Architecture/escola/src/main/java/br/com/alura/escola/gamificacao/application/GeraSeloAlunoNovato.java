package br.com.alura.escola.gamificacao.application;

import br.com.alura.escola.gamificacao.domain.selo.Selo;
import br.com.alura.escola.gamificacao.domain.selo.SeloRepository;
import br.com.alura.escola.shared.dominio.Cpf;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.TipoDeEvento;

public class GeraSeloAlunoNovato extends Ouvinte {

    private final SeloRepository seloRepository;

    public GeraSeloAlunoNovato(SeloRepository seloRepository) {
        this.seloRepository = seloRepository;
    }

    @Override
    protected void reageAo(Evento evento) {
        var cpf = (Cpf) evento.informacoes().get("cpf");
        var novato = new Selo(cpf, "Novato");

        this.seloRepository.adicionar(novato);
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }
}
