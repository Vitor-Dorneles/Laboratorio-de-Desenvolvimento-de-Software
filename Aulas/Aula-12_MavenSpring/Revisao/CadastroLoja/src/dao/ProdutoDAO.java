package dao;

import beans.Categoria;
import beans.Produto;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Conexao conexao;
    private Connection conn;

    public ProdutoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Produto produto) {
        String sql = "INSERT INTO produtos (nome, preco, quantidade, categoria_id) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getCategoria().getId()); // do objeto vai só o id
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir produto: " + ex.getMessage());
        }
    }

    public void editar(Produto produto) {
        String sql = "UPDATE produtos SET nome = ?, preco = ?, quantidade = ?, categoria_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getCategoria().getId()); // é aqui que a categoria muda na edição
            stmt.setInt(5, produto.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao editar produto: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir produto: " + ex.getMessage());
        }
    }

    public Produto getProduto(int id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return montarProduto(rs, new CategoriaDAO());
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar produto: " + ex.getMessage());
        }
        return null; // id não existe
    }

    public List<Produto> getProdutos() {
        return buscar("", null);
    }

    // nome vazio = todos os nomes; categoria null = todas as categorias
    public List<Produto> buscar(String nome, Categoria categoria) {
        String sql = "SELECT * FROM produtos WHERE nome LIKE ?";
        if (categoria != null) {
            sql += " AND categoria_id = ?";
        }
        sql += " ORDER BY nome";

        List<Produto> lista = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            if (categoria != null) {
                stmt.setInt(2, categoria.getId());
            }
            ResultSet rs = stmt.executeQuery();
            CategoriaDAO cDAO = new CategoriaDAO();
            while (rs.next()) {
                lista.add(montarProduto(rs, cDAO));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar produtos: " + ex.getMessage());
        }
        return lista;
    }

    // transforma a linha atual do ResultSet num Produto, buscando o objeto Categoria pelo categoria_id
    private Produto montarProduto(ResultSet rs, CategoriaDAO cDAO) throws SQLException {
        Produto p = new Produto();
        p.setId(rs.getInt("id"));
        p.setNome(rs.getString("nome"));
        p.setPreco(rs.getDouble("preco"));
        p.setQuantidade(rs.getInt("quantidade"));
        p.setCategoria(cDAO.getCategoria(rs.getInt("categoria_id")));
        return p;
    }
}
