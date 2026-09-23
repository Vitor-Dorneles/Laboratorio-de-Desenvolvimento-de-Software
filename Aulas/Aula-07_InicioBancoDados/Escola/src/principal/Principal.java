/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import beans.Pessoa;
import conexao.Conectar;
import dao.PessoaDAO;

/**
 *
 * @author laboratorio
 */
public class Principal {
    public static void main(String[] args) {
        Conectar c = new Conectar();
        c.getConectar();
        
        Pessoa p = new Pessoa();
        p.setNome("Vitor Santos");
        p.setIdioma("Portugues");
        p.setSexo("M");
        PessoaDAO pdao = new PessoaDAO();
        pdao.inserir(p);
    }
    
    
}
