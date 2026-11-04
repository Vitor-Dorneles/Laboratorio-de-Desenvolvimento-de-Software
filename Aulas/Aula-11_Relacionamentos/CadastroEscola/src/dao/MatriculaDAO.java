package dao;

import beans.Matricula;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {

    private Conexao conexao;

    public MatriculaDAO() {
        this.conexao = new Conexao();
    }

    public void inserir(Matricula matricula) throws SQLException {
        String sql = "INSERT INTO matricula(id_aluno, id_professor, data_matricula) VALUES(?,?,?)";
        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matricula.getIdAluno());
            stmt.setInt(2, matricula.getIdProfessor());
            stmt.setObject(3, matricula.getDataMatricula());
            stmt.executeUpdate();
        }
    }

    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM matricula WHERE id = ?";
        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Matricula> getMatriculas(String nome) throws SQLException {
        String sql = "SELECT m.id, m.id_aluno, m.id_professor, m.data_matricula, "
                + "a.nome AS nome_aluno, p.nome AS nome_professor "
                + "FROM matricula m "
                + "JOIN aluno a ON a.id = m.id_aluno "
                + "JOIN professor p ON p.id = m.id_professor "
                + "WHERE a.nome LIKE ? OR p.nome LIKE ? "
                + "ORDER BY m.data_matricula DESC";
        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            stmt.setString(2, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                List<Matricula> listaMatriculas = new ArrayList<>();
                while (rs.next()) {
                    Matricula m = new Matricula();
                    m.setId(rs.getInt("id"));
                    m.setIdAluno(rs.getInt("id_aluno"));
                    m.setIdProfessor(rs.getInt("id_professor"));
                    m.setDataMatricula(rs.getObject("data_matricula", LocalDate.class));
                    m.setNomeAluno(rs.getString("nome_aluno"));
                    m.setNomeProfessor(rs.getString("nome_professor"));
                    listaMatriculas.add(m);
                }
                return listaMatriculas;
            }
        }
    }
}
