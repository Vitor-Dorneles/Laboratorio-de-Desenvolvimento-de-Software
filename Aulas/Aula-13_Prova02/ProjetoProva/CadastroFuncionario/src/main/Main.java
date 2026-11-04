package main;

import view.MenuPrincipal;

public class Main {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro ao aplicar o tema Nimbus: " + ex.getMessage());
        }

        java.awt.EventQueue.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }
}
