package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conectar {
    public Connection getConectar(){
        Connection conn;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bdaula07?userTimeZone=true&serverTimeZone=UTC",
                    "root","laboratorio"); //se ligar na senha
            System.out.println("Conexão efetuada!");
            return conn;
        } catch (Exception e) {
            System.out.println("Erro ao conectar no BD"+e.getMessage());
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, e);
        }
        return  null;
    }
    
}