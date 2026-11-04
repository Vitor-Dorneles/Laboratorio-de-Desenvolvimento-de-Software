package view;


public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuSessao = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenuItem();
        jMenuCadastro = new javax.swing.JMenu();
        menuCadFuncionario = new javax.swing.JMenuItem();
        jMenuConsultas = new javax.swing.JMenu();
        menuRelFuncionarios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CC UFN");

        lblTitulo.setText("Empresa cc UFN");

        jLabel1.setText("Cad de Funcionarios");

        jMenuSessao.setText("Arquivo");

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenuSessao.add(menuSair);

        jMenuBar1.add(jMenuSessao);

        jMenuCadastro.setText("Cadastro");

        menuCadFuncionario.setText("Funcionario");
        menuCadFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadFuncionarioActionPerformed(evt);
            }
        });
        jMenuCadastro.add(menuCadFuncionario);

        jMenuBar1.add(jMenuCadastro);

        jMenuConsultas.setText("Consultas");

        menuRelFuncionarios.setText("Relatório de Funcionarios");
        menuRelFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelFuncionariosActionPerformed(evt);
            }
        });
        jMenuConsultas.add(menuRelFuncionarios);

        jMenuBar1.add(jMenuConsultas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 257, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblTitulo))
                .addGap(0, 258, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 170, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(0, 148, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed
    private void menuCadFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadFuncionarioActionPerformed
        CadastroFuncionario cadFuncionario = new CadastroFuncionario();
        cadFuncionario.setVisible(true);
    }//GEN-LAST:event_menuCadFuncionarioActionPerformed

    private void menuRelFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelFuncionariosActionPerformed
        ConsultaFuncionario relFuncionario = new ConsultaFuncionario();
        relFuncionario.setVisible(true);
    }//GEN-LAST:event_menuRelFuncionariosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuConsultas;
    private javax.swing.JMenu jMenuSessao;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenuItem menuCadFuncionario;
    private javax.swing.JMenuItem menuRelFuncionarios;
    private javax.swing.JMenuItem menuSair;
    // End of variables declaration//GEN-END:variables
}
