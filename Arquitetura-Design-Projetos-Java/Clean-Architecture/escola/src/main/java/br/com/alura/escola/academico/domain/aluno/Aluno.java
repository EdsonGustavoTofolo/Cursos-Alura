package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.shared.dominio.Cpf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Classe Aluno é considerada uma Entidade, pois contém um atributo (cpf) como identidade única que irá
 * diferenciar duas instancias, ou, dois alunos.
 * DDD:
 * Classe entidade composta por varios objetos VO, esta classe é chamada de
 * Aggregate Root
 */
public class Aluno {

    private Cpf cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>();

    public Aluno(Cpf cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(String ddd, String numero) throws IllegalArgumentException {
        // Bussiness Invariant pelo DDD: validação de regra de negocio
        if (this.telefones.size() == 2) {
            throw new IllegalArgumentException("Numero maximo de telefones ja atingidos!");
        }
        this.telefones.add(new Telefone(ddd, numero));
    }

    public String getCpf() {
        return cpf.getNumero();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return Collections.unmodifiableList(telefones);
    }
}
