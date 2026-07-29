/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Construtores;

/**
 *
 * @author laboratorio
 */
public class ContaCorrente {

    private float saldo;

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

//•O método definirSaldoInicial deve atribuir o valor passado por parâmetro ao atribuito saldo
    public void definirSaldoInicial(float valor) {
        saldo = valor;
    }

    //•O método depositar, deve adicionar o valor passado por parâmetro ao atributo saldo
    public void depositarValor(float valor) {
        saldo = valor + saldo;
    }

    //•O método sacar deve reduzir o valor passado por parâmetro do saldo já existente
    public boolean sacar(float valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

}
