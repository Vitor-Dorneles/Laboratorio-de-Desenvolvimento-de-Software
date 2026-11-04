package dao;

import beans.Aluno;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private Conexao conexao;

    public AlunoDAO() {
        this.conexao = new Conexao();
    }

    public void inserir(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO aluno(nome, idade, sexo, curso) VALUES(?,?,?,?)";
        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getSexo());
            stmt.setString(4, aluno.getCurso());
            stmt.executeUpdate();
        }
    }

    public Aluno getAluno(int id) throws SQLException {
        String sql = "SELECT * FROM aluno WHERE id = ?";
        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return montar(rs);
                }
                return null;
            }
        }
    }

    public boolean editar(Aluno aluno) throws SQLException {
        String sql = "UPDATE aluno SET nome=?, idade=?, sexo=?, curso=? WHERE id = ?";
        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getSexo());
            stmt.setString(4, aluno.getCurso());
            stmt.setInt(5, aluno.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM aluno WHERE id = ?";
        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Aluno> getAlunos() throws SQLException {
        return getAlunos("", "");
    }

    public List<Aluno> getAlunos(String nome, String sexo) throws SQLException {
        String sql = "SELECT * FROM aluno WHERE nome LIKE ? AND sexo LIKE ? ORDER BY nome";
        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            stmt.setString(2, sexo.isEmpty() ? "%" : sexo);
            try (ResultSet rs = stmt.executeQuery()) {
                List<Aluno> listaAlunos = new ArrayList<>();
                while (rs.next()) {
                    listaAlunos.add(montar(rs));
                }
                return listaAlunos;
            }
        }
    }

    private Aluno montar(ResultSet rs) throws SQLException {
        Aluno a = new Aluno();
        a.setId(rs.getInt("id"));
        a.setNome(rs.getString("nome"));
        a.setIdade(rs.getInt("idade"));
        a.setSexo(rs.getString("sexo"));
        a.setCurso(rs.getString("curso"));
        return a;
    }
}
