/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Construtores;


/**
 *
 * @author laboratorio
 */
public class ProjetoConta {
    public static void main(String[] args) {
        ContaCorrente novaConta = new ContaCorrente();
        
        novaConta.definirSaldoInicial(666);
        System.out.println(novaConta.getSaldo());

    }
}
