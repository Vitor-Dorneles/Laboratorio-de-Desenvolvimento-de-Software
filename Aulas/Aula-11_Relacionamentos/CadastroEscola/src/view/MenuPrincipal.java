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
        menuCadAluno = new javax.swing.JMenuItem();
        menuCadProfessor = new javax.swing.JMenuItem();
        menuCadMatricula = new javax.swing.JMenuItem();
        jMenuAlterar = new javax.swing.JMenu();
        menuAltAluno = new javax.swing.JMenuItem();
        menuAltProfessor = new javax.swing.JMenuItem();
        jMenuConsultas = new javax.swing.JMenu();
        menuConAlunos = new javax.swing.JMenuItem();
        menuConProfessores = new javax.swing.JMenuItem();
        menuConMatriculas = new javax.swing.JMenuItem();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Escola - Menu Principal");

        lblTitulo.setText("Sistema Escola");

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

        menuCadAluno.setText("Aluno");
        menuCadAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadAlunoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(menuCadAluno);

        menuCadProfessor.setText("Professor");
        menuCadProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadProfessorActionPerformed(evt);
            }
        });
        jMenuCadastro.add(menuCadProfessor);

        menuCadMatricula.setText("Matrícula");
        menuCadMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadMatriculaActionPerformed(evt);
            }
        });
        jMenuCadastro.add(menuCadMatricula);

        jMenuBar1.add(jMenuCadastro);

        jMenuAlterar.setText("Alterar / Excluir");

        menuAltAluno.setText("Aluno");
        menuAltAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltAlunoActionPerformed(evt);
            }
        });
        jMenuAlterar.add(menuAltAluno);

        menuAltProfessor.setText("Professor");
        menuAltProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltProfessorActionPerformed(evt);
            }
        });
        jMenuAlterar.add(menuAltProfessor);

        jMenuBar1.add(jMenuAlterar);

        jMenuConsultas.setText("Consultas");

        menuConAlunos.setText("Alunos");
        menuConAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConAlunosActionPerformed(evt);
            }
        });
        jMenuConsultas.add(menuConAlunos);

        menuConProfessores.setText("Professores");
        menuConProfessores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConProfessoresActionPerformed(evt);
            }
        });
        jMenuConsultas.add(menuConProfessores);

        menuConMatriculas.setText("Matrículas");
        menuConMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConMatriculasActionPerformed(evt);
            }
        });
        jMenuConsultas.add(menuConMatriculas);

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

    private void menuCadAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadAlunoActionPerformed
        CadastroAluno cadAluno = new CadastroAluno();
        cadAluno.setVisible(true);
    }//GEN-LAST:event_menuCadAlunoActionPerformed

    private void menuCadProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadProfessorActionPerformed
        CadastroProfessor cadProfessor = new CadastroProfessor();
        cadProfessor.setVisible(true);
    }//GEN-LAST:event_menuCadProfessorActionPerformed

    private void menuCadMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadMatriculaActionPerformed
        CadastroMatricula cadMatricula = new CadastroMatricula();
        cadMatricula.setVisible(true);
    }//GEN-LAST:event_menuCadMatriculaActionPerformed

    private void menuAltAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltAlunoActionPerformed
        ModificarAluno modAluno = new ModificarAluno();
        modAluno.setVisible(true);
    }//GEN-LAST:event_menuAltAlunoActionPerformed

    private void menuAltProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltProfessorActionPerformed
        ModificarProfessor modProfessor = new ModificarProfessor();
        modProfessor.setVisible(true);
    }//GEN-LAST:event_menuAltProfessorActionPerformed

    private void menuConAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConAlunosActionPerformed
        PesquisaAluno pesAluno = new PesquisaAluno();
        pesAluno.setVisible(true);
    }//GEN-LAST:event_menuConAlunosActionPerformed

    private void menuConProfessoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConProfessoresActionPerformed
        PesquisaProfessor pesProfessor = new PesquisaProfessor();
        pesProfessor.setVisible(true);
    }//GEN-LAST:event_menuConProfessoresActionPerformed

    private void menuConMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConMatriculasActionPerformed
        PesquisaMatricula pesMatricula = new PesquisaMatricula();
        pesMatricula.setVisible(true);
    }//GEN-LAST:event_menuConMatriculasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuAlterar;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuConsultas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenuItem menuAltAluno;
    private javax.swing.JMenuItem menuAltProfessor;
    private javax.swing.JMenuItem menuCadAluno;
    private javax.swing.JMenuItem menuCadMatricula;
    private javax.swing.JMenuItem menuCadProfessor;
    private javax.swing.JMenuItem menuConAlunos;
    private javax.swing.JMenuItem menuConMatriculas;
    private javax.swing.JMenuItem menuConProfessores;
    private javax.swing.JMenuItem menuSair;
    // End of variables declaration//GEN-END:variables
}
