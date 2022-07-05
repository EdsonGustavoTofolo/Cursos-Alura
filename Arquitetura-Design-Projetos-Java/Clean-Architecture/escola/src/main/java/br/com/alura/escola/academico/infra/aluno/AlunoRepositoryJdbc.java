package br.com.alura.escola.academico.infra.aluno;

import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.academico.domain.aluno.AlunoRepository;
import br.com.alura.escola.shared.dominio.Cpf;
import br.com.alura.escola.academico.domain.aluno.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AlunoRepositoryJdbc implements AlunoRepository {

    private final Connection connection;

    public AlunoRepositoryJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        String sql = "INSERT INTO ALUNOS VALUES(?,?,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();

            sql = "INSERT INTO TELEFONES VALUES(?,?)";
            ps = this.connection.prepareStatement(sql);

            for (Telefone telefone : aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCpf(Cpf cpf) {
        return null;
    }

    @Override
    public List<Aluno> buscarTodosAlunosMatriculados() {
        return null;
    }
}
