package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Pessoa;
import beans.Veiculo;
import conexao.Conexao;
import dao.PessoaDAO;

public class VeiculoDAO {
        private Conexao conexao;
    private Connection conn;

    public VeiculoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (modelo, placa, id_pessoa) VALUES (?,?,?);";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getPessoaObj().getId());
            // stmt.setInt(4, veiculo.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Veiculo: " + ex.getMessage());
        }
    }


    public void editar(Veiculo veiculo) {
        String sql = "UPDATE veiculo set modelo = ?, placa = ?, id_pessoa =? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getPessoaObj().getId());
            stmt.setInt(4, veiculo.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Veiculo: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "delete from veiculo WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

        } catch (Exception e) {
            System.out.println("Erro ao excluir veiculo: " + e.getMessage());
        }
    }

    public Veiculo getVeiculo(int id) {
        String sql = "SELECT * FROM veiculo WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Veiculo v = new Veiculo();

            rs.first();

            v.setId(rs.getInt("id"));
            v.setModelo(rs.getString("modelo"));
            v.setPlaca(rs.getString("placa"));
            PessoaDAO pDao = new PessoaDAO();

            Pessoa p = pDao.getPessoa(rs.getInt("id_pessoa"));
            v.setPessoaObj(p);
            return v;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar pessoa: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Veiculo> getVeiculos() {
        String sql = "SELECT * FROM veiculo";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery();
            List<Veiculo> listaVeiculos = new ArrayList();

            while (rs.next()) {
                Veiculo v = new Veiculo();
                v.setId(rs.getInt("id"));
                v.setModelo(rs.getString("modelo"));
                v.setPlaca(rs.getString("placa"));
                PessoaDAO pDAO = new PessoaDAO();

                Pessoa p = pDAO.getPessoa(rs.getInt("id_pessoa"));
                v.setPessoaObj(p);
                listaVeiculos.add(v);
            }
            return listaVeiculos;
        } catch (SQLException ex) {
            System.out.println("erro ao consultar todos os veiculos: " + ex.getMessage());
            return null;
        }
    }

}