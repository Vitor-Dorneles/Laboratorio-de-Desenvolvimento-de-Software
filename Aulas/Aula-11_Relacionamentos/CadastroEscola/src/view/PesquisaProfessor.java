package view;

import beans.Professor;
import dao.ProfessorDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PesquisaProfessor extends javax.swing.JFrame {

    public PesquisaProfessor() {
        initComponents();
        preencherTabela();
    }

    public String sexoSelecionado() {
        String sexo = "";

        if (rdoMasculino.isSelected()) {
            sexo = "M";
        }
        else if (rdoFeminino.isSelected()) {
            sexo = "F";
        }

        return sexo;
    }

    public void preencherTabela() {
        DefaultTableModel tabelaProfessores = (DefaultTableModel) tblProfessores.getModel();
        tabelaProfessores.setNumRows(0);

        try {
            ProfessorDAO pDAO = new ProfessorDAO();
            List<Professor> listaProfessores = pDAO.getProfessores(txtNome.getText().trim(), sexoSelecionado());

            for (Professor p : listaProfessores) {
                Object[] obj = new Object[] {
                    p.getId(),
                    p.getNome(),
                    p.getIdade(),
                    p.getSexo(),
                    p.getDisciplina() };
                tabelaProfessores.addRow(obj);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar professores: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngSexo = new javax.swing.ButtonGroup();
        lblPesquisaProfessor = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        rdoTodos = new javax.swing.JRadioButton();
        rdoMasculino = new javax.swing.JRadioButton();
        rdoFeminino = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProfessores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Professores");

        lblPesquisaProfessor.setText("Consulta de Professores");

        lblNome.setText("Nome:");

        txtNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNomeCaretUpdate(evt);
            }
        });

        lblSexo.setText("Sexo:");

        btngSexo.add(rdoTodos);
        rdoTodos.setText("Todos");
        rdoTodos.setSelected(true);
        rdoTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTodosActionPerformed(evt);
            }
        });

        btngSexo.add(rdoMasculino);
        rdoMasculino.setText("Masculino");
        rdoMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMasculinoActionPerformed(evt);
            }
        });

        btngSexo.add(rdoFeminino);
        rdoFeminino.setText("Feminino");
        rdoFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFemininoActionPerformed(evt);
            }
        });

        tblProfessores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Idade", "Sexo", "Disciplina"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProfessores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPesquisaProfessor)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoMasculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoFeminino))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPesquisaProfessor)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo)
                    .addComponent(rdoTodos)
                    .addComponent(rdoMasculino)
                    .addComponent(rdoFeminino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNomeCaretUpdate
        preencherTabela();
    }//GEN-LAST:event_txtNomeCaretUpdate

    private void rdoTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTodosActionPerformed
        preencherTabela();
    }//GEN-LAST:event_rdoTodosActionPerformed

    private void rdoMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMasculinoActionPerformed
        preencherTabela();
    }//GEN-LAST:event_rdoMasculinoActionPerformed

    private void rdoFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFemininoActionPerformed
        preencherTabela();
    }//GEN-LAST:event_rdoFemininoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btngSexo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPesquisaProfessor;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JRadioButton rdoFeminino;
    private javax.swing.JRadioButton rdoMasculino;
    private javax.swing.JRadioButton rdoTodos;
    private javax.swing.JTable tblProfessores;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
