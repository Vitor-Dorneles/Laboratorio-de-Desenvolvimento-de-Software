package view;

import beans.Aluno;
import dao.AlunoDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModificarAluno extends javax.swing.JFrame {

    public ModificarAluno() {
        initComponents();
        habilitarEdicao(false);
        getRootPane().setDefaultButton(btnConsultar);
    }

    public int converterNumero(String texto) {
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    public void habilitarEdicao(boolean habilitar) {
        txtNome.setEnabled(habilitar);
        txtIdade.setEnabled(habilitar);
        txtCurso.setEnabled(habilitar);
        rdoMasculino.setEnabled(habilitar);
        rdoFeminino.setEnabled(habilitar);
        btnAtualizar.setEnabled(habilitar);
        btnExcluir.setEnabled(habilitar);
    }

    public void limparFormulario() {
        txtId.setText("");
        txtIdInfo.setText("");
        txtNome.setText("");
        txtIdade.setText("");
        txtCurso.setText("");
        btngSexo.clearSelection();
        habilitarEdicao(false);
        txtId.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngSexo = new javax.swing.ButtonGroup();
        lblModificarAluno = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        lblIdInfo = new javax.swing.JLabel();
        txtIdInfo = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblIdade = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        rdoMasculino = new javax.swing.JRadioButton();
        rdoFeminino = new javax.swing.JRadioButton();
        lblCurso = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar / Excluir Aluno");

        lblModificarAluno.setText("Alterar / Excluir Aluno");

        lblId.setText("Buscar por ID:");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        lblIdInfo.setText("ID:");

        txtIdInfo.setEditable(false);

        lblNome.setText("Nome:");

        lblIdade.setText("Idade:");

        lblSexo.setText("Sexo:");

        btngSexo.add(rdoMasculino);
        rdoMasculino.setText("Masculino");

        btngSexo.add(rdoFeminino);
        rdoFeminino.setText("Feminino");

        lblCurso.setText("Curso:");

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
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
                        .addComponent(lblModificarAluno))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAtualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblId)
                                    .addComponent(lblIdInfo)
                                    .addComponent(lblNome)
                                    .addComponent(lblIdade)
                                    .addComponent(lblSexo)
                                    .addComponent(lblCurso))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnConsultar))
                                    .addComponent(txtIdInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdoFeminino))
                                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblModificarAluno)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdInfo)
                    .addComponent(txtIdInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdade)
                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(rdoMasculino)
                    .addComponent(rdoFeminino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurso)
                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar)
                    .addComponent(btnExcluir))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        int idAluno = converterNumero(txtId.getText());

        if (idAluno <= 0) {
            JOptionPane.showMessageDialog(null, "Digite um ID válido", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else {
            try {
                AlunoDAO aDAO = new AlunoDAO();
                Aluno a = aDAO.getAluno(idAluno);

                if (a == null) {
                    limparFormulario();
                    JOptionPane.showMessageDialog(null, "Aluno não encontrado", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    txtIdInfo.setText(String.valueOf(a.getId()));
                    txtNome.setText(a.getNome());
                    txtIdade.setText(String.valueOf(a.getIdade()));
                    txtCurso.setText(a.getCurso());

                    if (a.getSexo().equals("M")) {
                        rdoMasculino.setSelected(true);
                    }
                    else if (a.getSexo().equals("F")) {
                        rdoFeminino.setSelected(true);
                    }

                    habilitarEdicao(true);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao consultar aluno: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        String sexo = "";

        if ("".equals(txtNome.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Você deve digitar um nome antes de atualizar", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else if (converterNumero(txtIdade.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "A idade deve ser um número inteiro maior que zero", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else if (!rdoMasculino.isSelected() && !rdoFeminino.isSelected()) {
            JOptionPane.showMessageDialog(null, "Você deve selecionar um sexo antes de atualizar", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else if ("".equals(txtCurso.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Você deve digitar um curso antes de atualizar", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else {
            if (rdoMasculino.isSelected()) {
                sexo = "M";
            }
            else if (rdoFeminino.isSelected()) {
                sexo = "F";
            }

            Aluno a = new Aluno();
            a.setId(Integer.parseInt(txtIdInfo.getText()));
            a.setNome(txtNome.getText().trim());
            a.setIdade(converterNumero(txtIdade.getText()));
            a.setSexo(sexo);
            a.setCurso(txtCurso.getText().trim());

            try {
                AlunoDAO aDAO = new AlunoDAO();

                if (aDAO.editar(a)) {
                    JOptionPane.showMessageDialog(null, "Aluno atualizado", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Aluno não existe mais no banco", "Alerta", JOptionPane.WARNING_MESSAGE);
                }

                limparFormulario();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar aluno: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir? As matrículas deste aluno também serão excluídas", "Exclusão", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                AlunoDAO aDAO = new AlunoDAO();
                aDAO.excluir(Integer.parseInt(txtIdInfo.getText()));
                limparFormulario();
                JOptionPane.showMessageDialog(null, "Aluno excluído", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir aluno: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.ButtonGroup btngSexo;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdInfo;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblModificarAluno;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JRadioButton rdoFeminino;
    private javax.swing.JRadioButton rdoMasculino;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdInfo;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
