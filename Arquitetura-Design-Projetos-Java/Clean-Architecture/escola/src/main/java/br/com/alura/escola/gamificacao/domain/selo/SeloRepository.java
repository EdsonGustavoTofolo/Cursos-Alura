package br.com.alura.escola.gamificacao.domain.selo;

import br.com.alura.escola.shared.dominio.Cpf;

import java.util.List;

public interface SeloRepository {

    void adicionar(Selo selo);
    List<Selo> selosDoAlunoComCpf(Cpf cpf);
}
