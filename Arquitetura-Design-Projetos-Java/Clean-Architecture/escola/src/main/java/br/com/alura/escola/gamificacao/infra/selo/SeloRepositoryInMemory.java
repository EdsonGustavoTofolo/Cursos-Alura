package br.com.alura.escola.gamificacao.infra.selo;

import br.com.alura.escola.shared.dominio.Cpf;
import br.com.alura.escola.gamificacao.domain.selo.Selo;
import br.com.alura.escola.gamificacao.domain.selo.SeloRepository;

import java.util.List;

public class SeloRepositoryInMemory implements SeloRepository {
    @Override
    public void adicionar(Selo selo) {

    }

    @Override
    public List<Selo> selosDoAlunoComCpf(Cpf cpf) {
        return null;
    }
}
