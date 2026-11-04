package view;

import beans.Aluno;
import beans.Matricula;
import beans.Professor;
import dao.AlunoDAO;
import dao.MatriculaDAO;
import dao.ProfessorDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javax.swing.JOptionPane;

public class CadastroMatricula extends javax.swing.JFrame {

    static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

    public CadastroMatricula() {
        initComponents();
        txtData.setText(LocalDate.now().format(FORMATO_DATA));
        carregarCombos();
        getRootPane().setDefaultButton(btnSalvar);
    }

    public void carregarCombos() {
        try {
            AlunoDAO aDAO = new AlunoDAO();
            ProfessorDAO pDAO = new ProfessorDAO();

            for (Aluno a : aDAO.getAlunos()) {
                cmbAluno.addItem(a);
            }
            for (Professor p : pDAO.getProfessores()) {
                cmbProfessor.addItem(p);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar alunos e professores: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public LocalDate converterData(String texto) {
        try {
            return LocalDate.parse(texto.trim(), FORMATO_DATA);
        } catch (DateTimeParseException ex) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCadastroMatricula = new javax.swing.JLabel();
        lblAluno = new javax.swing.JLabel();
        cmbAluno = new javax.swing.JComboBox<>();
        lblProfessor = new javax.swing.JLabel();
        cmbProfessor = new javax.swing.JComboBox<>();
        lblData = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Matrícula");

        lblCadastroMatricula.setText("Cadastro de Matrícula");

        lblAluno.setText("Aluno:");

        lblProfessor.setText("Professor:");

        lblData.setText("Data (dd/mm/aaaa):");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCadastroMatricula))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalvar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAluno)
                                    .addComponent(lblProfessor)
                                    .addComponent(lblData))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCadastroMatricula)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAluno)
                    .addComponent(cmbAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProfessor)
                    .addComponent(cmbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(btnSalvar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (cmbAluno.getSelectedItem() == null || cmbProfessor.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Cadastre ao menos um aluno e um professor antes", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else if (converterData(txtData.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Data inválida, use dd/mm/aaaa", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else {
            Aluno a = (Aluno) cmbAluno.getSelectedItem();
            Professor p = (Professor) cmbProfessor.getSelectedItem();

            Matricula m = new Matricula();
            m.setIdAluno(a.getId());
            m.setIdProfessor(p.getId());
            m.setDataMatricula(converterData(txtData.getText()));

            try {
                MatriculaDAO mDAO = new MatriculaDAO();
                mDAO.inserir(m);
                JOptionPane.showMessageDialog(null, "Matrícula adicionada com sucesso", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir matrícula: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Aluno> cmbAluno;
    private javax.swing.JComboBox<Professor> cmbProfessor;
    private javax.swing.JLabel lblAluno;
    private javax.swing.JLabel lblCadastroMatricula;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblProfessor;
    private javax.swing.JTextField txtData;
    // End of variables declaration//GEN-END:variables
}
