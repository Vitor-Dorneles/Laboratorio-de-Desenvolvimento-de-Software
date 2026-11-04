package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Funcionario;
import conexao.Conexao;

public class FuncionarioDAO {
    private Conexao conexao;
    private Connection conn;

    public FuncionarioDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Funcionario f) {

        try {
            String sql = "INSERT INTO funcionarios(nome, idade, genero, cargo, salario) VALUES(?,?,?,?,?);";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            stmt.setInt(2, f.getIdade());
            stmt.setString(3, f.getGenero());
            stmt.setString(4, f.getCargo());
            stmt.setDouble(5, f.getSalario());

            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Funcionario: " + ex.getMessage());
        }
    }
    
    public List<Funcionario> listar() {

        String sql = "SELECT * FROM funcionarios";
        try {

            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE); //monta

            ResultSet rs = stmt.executeQuery(); //obtenho o retorno da consulta e armazeno no ResultSet
            List<Funcionario> listaFuncionarios = new ArrayList(); //Preparo uma lista de objetos que vou armazenar e 
            // percorre rs e salvar as infromacoes dentro de um objeto e depois adiciona na lista
            listaFuncionarios.clear();
            while (rs.next()) { // só entramos se retornar algo
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id")); //obtenção dos dados
                f.setNome(rs.getString("nome"));
                f.setIdade(rs.getInt("idade"));
                f.setGenero(rs.getString("genero"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getDouble("salario"));
                
                listaFuncionarios.add(f);
            }
            return listaFuncionarios;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar todas os funcionarios: " + ex.getMessage());
            return null;
        }
    }
}
