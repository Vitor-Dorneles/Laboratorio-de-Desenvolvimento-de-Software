package view;


public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenuItem();
        jMenuCadastro = new javax.swing.JMenu();
        menuCadPessoa = new javax.swing.JMenuItem();
        menuCadVeiculo = new javax.swing.JMenuItem();
        jMenuAlterar = new javax.swing.JMenu();
        menuAltPessoa = new javax.swing.JMenuItem();
        menuAltVeiculo = new javax.swing.JMenuItem();
        jMenuConsultas = new javax.swing.JMenu();
        menuConPessoas = new javax.swing.JMenuItem();
        menuRelPessoas = new javax.swing.JMenuItem();
        menuRelVeiculos = new javax.swing.JMenuItem();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Pessoas e Veículos");

        lblTitulo.setText("Cadastro de Pessoas e Veículos");

        jMenuArquivo.setText("Arquivo");

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenuArquivo.add(menuSair);

        jMenuBar1.add(jMenuArquivo);

        jMenuCadastro.setText("Cadastro");
        menuCadPessoa.setText("Pessoa");
        menuCadPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadPessoaActionPerformed(evt);
            }
        });
        jMenuCadastro.add(menuCadPessoa);

        menuCadVeiculo.setText("Veículo");
        menuCadVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadVeiculoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(menuCadVeiculo);

        jMenuBar1.add(jMenuCadastro);

        jMenuAlterar.setText("Alterar / Excluir");
        menuAltPessoa.setText("Pessoa");
        menuAltPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltPessoaActionPerformed(evt);
            }
        });
        jMenuAlterar.add(menuAltPessoa);

        menuAltVeiculo.setText("Veículo");
        menuAltVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltVeiculoActionPerformed(evt);
            }
        });
        jMenuAlterar.add(menuAltVeiculo);

        jMenuBar1.add(jMenuAlterar);

        jMenuConsultas.setText("Consultas");
        menuConPessoas.setText("Pessoas (por nome)");
        menuConPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConPessoasActionPerformed(evt);
            }
        });
        jMenuConsultas.add(menuConPessoas);

        menuRelPessoas.setText("Relatório de Pessoas");
        menuRelPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelPessoasActionPerformed(evt);
            }
        });
        jMenuConsultas.add(menuRelPessoas);

        menuRelVeiculos.setText("Relatório de Veículos");
        menuRelVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelVeiculosActionPerformed(evt);
            }
        });
        jMenuConsultas.add(menuRelVeiculos);

        jMenuBar1.add(jMenuConsultas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 230, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(0, 230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 170, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(0, 170, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed
    private void menuCadPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadPessoaActionPerformed
        CadastroPessoa cadPessoa = new CadastroPessoa();
        cadPessoa.setVisible(true);
    }//GEN-LAST:event_menuCadPessoaActionPerformed

    private void menuCadVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadVeiculoActionPerformed
        CadastroVeiculo cadVeiculo = new CadastroVeiculo();
        cadVeiculo.setVisible(true);
    }//GEN-LAST:event_menuCadVeiculoActionPerformed

    private void menuAltPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltPessoaActionPerformed
        ModificarDados modPessoa = new ModificarDados();
        modPessoa.setVisible(true);
    }//GEN-LAST:event_menuAltPessoaActionPerformed

    private void menuAltVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltVeiculoActionPerformed
        ConsultaEdicao modVeiculo = new ConsultaEdicao();
        modVeiculo.setVisible(true);
    }//GEN-LAST:event_menuAltVeiculoActionPerformed

    private void menuConPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConPessoasActionPerformed
        PesquisaNome pesPessoa = new PesquisaNome();
        pesPessoa.setVisible(true);
    }//GEN-LAST:event_menuConPessoasActionPerformed

    private void menuRelPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelPessoasActionPerformed
        TabelaRelatorio relPessoas = new TabelaRelatorio();
        relPessoas.setVisible(true);
    }//GEN-LAST:event_menuRelPessoasActionPerformed

    private void menuRelVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelVeiculosActionPerformed
        RelatorioVeiculo relVeiculos = new RelatorioVeiculo();
        relVeiculos.setVisible(true);
    }//GEN-LAST:event_menuRelVeiculosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuAlterar;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuConsultas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenuItem menuAltPessoa;
    private javax.swing.JMenuItem menuAltVeiculo;
    private javax.swing.JMenuItem menuCadPessoa;
    private javax.swing.JMenuItem menuCadVeiculo;
    private javax.swing.JMenuItem menuConPessoas;
    private javax.swing.JMenuItem menuRelPessoas;
    private javax.swing.JMenuItem menuRelVeiculos;
    private javax.swing.JMenuItem menuSair;
    // End of variables declaration//GEN-END:variables
}
