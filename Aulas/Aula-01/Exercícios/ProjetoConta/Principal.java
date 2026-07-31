public class Principal{
public static void main(String[] args) {
      ContaCorrente2 c = new ContaCorrente2();

      c.definirSaldoInicial(4000);
      c.sacar(500);
      c.depositar(510);
      System.out.printl("O valor do saldo é: " c.saldo);
}
}
