/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import beans.Pessoa;
import dao.PessoaDAO;
import java.io.IOException;

/**
 *
 * @author laboratorio
 */
public class Servidor {
    public static void main(String[] args) {
        int porta = 12345; //uma constante para a porta

        try (ServerSocket servidorSocket = new ServerSocket(porta)){
            System.out.println("Servidor aguardando conexões na porta " + porta);
            while (true) {
                try {
                    Socket clienteSocket = servidorSocket.accept();
                    System.out.println("Conexão aceita de " + clienteSocket.getInetAddress());
                    ObjectOutputStream out = new ObjectOutputStream(clienteSocket.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(clienteSocket.getInputStream());

                    int id = in.readInt();
                    System.out.println("ID recebido: " + id);

                    //simule a obtenção de uma Pessoa a partir do id
                    PessoaDAO pdao = new PessoaDAO();
                    Pessoa p = pdao.getPessoa(id);

                    out.writeObject(p);
                } catch (IOException ex) {
                    System.out.println("Erro ao aceitar conexão do cliete: "+ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println("Erro ao criar o ServerSocket");
        }
    }
}
