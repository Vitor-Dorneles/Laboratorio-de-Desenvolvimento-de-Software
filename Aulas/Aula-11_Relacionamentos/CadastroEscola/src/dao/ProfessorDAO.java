package dao;

import beans.Professor;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    private Conexao conexao;

    public ProfessorDAO() {
        this.conexao = new Conexao();
    }

    public void inserir(Professor professor) throws SQLException {
        String sql = "INSERT INTO professor(nome, idade, sexo, disciplina) VALUES(?,?,?,?)";
        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getIdade());
            stmt.setString(3, professor.getSexo());
            stmt.setString(4, professor.getDisciplina());
            stmt.executeUpdate();
        }
    }

    public Professor getProfessor(int id) throws SQLException {
        String sql = "SELECT * FROM professor WHERE id = ?";
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

    public boolean editar(Professor professor) throws SQLException {
        String sql = "UPDATE professor SET nome=?, idade=?, sexo=?, disciplina=? WHERE id = ?";
        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getIdade());
            stmt.setString(3, professor.getSexo());
            stmt.setString(4, professor.getDisciplina());
            stmt.setInt(5, professor.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM professor WHERE id = ?";
        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Professor> getProfessores() throws SQLException {
        return getProfessores("", "");
    }

    public List<Professor> getProfessores(String nome, String sexo) throws SQLException {
        String sql = "SELECT * FROM professor WHERE nome LIKE ? AND sexo LIKE ? ORDER BY nome";
        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            stmt.setString(2, sexo.isEmpty() ? "%" : sexo);
            try (ResultSet rs = stmt.executeQuery()) {
                List<Professor> listaProfessores = new ArrayList<>();
                while (rs.next()) {
                    listaProfessores.add(montar(rs));
                }
                return listaProfessores;
            }
        }
    }

    private Professor montar(ResultSet rs) throws SQLException {
        Professor p = new Professor();
        p.setId(rs.getInt("id"));
        p.setNome(rs.getString("nome"));
        p.setIdade(rs.getInt("idade"));
        p.setSexo(rs.getString("sexo"));
        p.setDisciplina(rs.getString("disciplina"));
        return p;
    }
}
