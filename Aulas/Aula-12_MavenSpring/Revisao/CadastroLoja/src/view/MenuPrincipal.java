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
        jMenuCategorias = new javax.swing.JMenu();
        menuCategorias = new javax.swing.JMenuItem();
        jMenuProdutos = new javax.swing.JMenu();
        menuCadProduto = new javax.swing.JMenuItem();
        menuAltProduto = new javax.swing.JMenuItem();
        menuListaProdutos = new javax.swing.JMenuItem();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Produtos");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setText("Cadastro de Produtos");

        jMenuArquivo.setText("Arquivo");

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });

        jMenuArquivo.add(menuSair);

        jMenuBar1.add(jMenuArquivo);

        jMenuCategorias.setText("Categorias");

        menuCategorias.setText("Cadastrar / Editar / Listar");
        menuCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCategoriasActionPerformed(evt);
            }
        });

        jMenuCategorias.add(menuCategorias);

        jMenuBar1.add(jMenuCategorias);

        jMenuProdutos.setText("Produtos");

        menuCadProduto.setText("Cadastrar");
        menuCadProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadProdutoActionPerformed(evt);
            }
        });

        jMenuProdutos.add(menuCadProduto);

        menuAltProduto.setText("Consultar / Editar / Excluir");
        menuAltProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltProdutoActionPerformed(evt);
            }
        });

        jMenuProdutos.add(menuAltProduto);

        menuListaProdutos.setText("Listar / Buscar");
        menuListaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListaProdutosActionPerformed(evt);
            }
        });

        jMenuProdutos.add(menuListaProdutos);

        jMenuBar1.add(jMenuProdutos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCategoriasActionPerformed
        new GerenciarCategorias().setVisible(true);
    }//GEN-LAST:event_menuCategoriasActionPerformed

    private void menuCadProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadProdutoActionPerformed
        new CadastroProduto().setVisible(true);
    }//GEN-LAST:event_menuCadProdutoActionPerformed

    private void menuAltProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltProdutoActionPerformed
        new ConsultaEdicaoProduto().setVisible(true);
    }//GEN-LAST:event_menuAltProdutoActionPerformed

    private void menuListaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListaProdutosActionPerformed
        new ListaProdutos().setVisible(true);
    }//GEN-LAST:event_menuListaProdutosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCategorias;
    private javax.swing.JMenu jMenuProdutos;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenuItem menuAltProduto;
    private javax.swing.JMenuItem menuCadProduto;
    private javax.swing.JMenuItem menuCategorias;
    private javax.swing.JMenuItem menuListaProdutos;
    private javax.swing.JMenuItem menuSair;
    // End of variables declaration//GEN-END:variables
}
