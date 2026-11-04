package view;

import beans.Professor;
import dao.ProfessorDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModificarProfessor extends javax.swing.JFrame {

    public ModificarProfessor() {
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
        txtDisciplina.setEnabled(habilitar);
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
        txtDisciplina.setText("");
        btngSexo.clearSelection();
        habilitarEdicao(false);
        txtId.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngSexo = new javax.swing.ButtonGroup();
        lblModificarProfessor = new javax.swing.JLabel();
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
        lblDisciplina = new javax.swing.JLabel();
        txtDisciplina = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar / Excluir Professor");

        lblModificarProfessor.setText("Alterar / Excluir Professor");

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

        lblDisciplina.setText("Disciplina:");

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
                        .addComponent(lblModificarProfessor))
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
                                    .addComponent(lblDisciplina))
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
                                    .addComponent(txtDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblModificarProfessor)
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
                    .addComponent(lblDisciplina)
                    .addComponent(txtDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        int idProfessor = converterNumero(txtId.getText());

        if (idProfessor <= 0) {
            JOptionPane.showMessageDialog(null, "Digite um ID válido", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else {
            try {
                ProfessorDAO pDAO = new ProfessorDAO();
                Professor p = pDAO.getProfessor(idProfessor);

                if (p == null) {
                    limparFormulario();
                    JOptionPane.showMessageDialog(null, "Professor não encontrado", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    txtIdInfo.setText(String.valueOf(p.getId()));
                    txtNome.setText(p.getNome());
                    txtIdade.setText(String.valueOf(p.getIdade()));
                    txtDisciplina.setText(p.getDisciplina());

                    if (p.getSexo().equals("M")) {
                        rdoMasculino.setSelected(true);
                    }
                    else if (p.getSexo().equals("F")) {
                        rdoFeminino.setSelected(true);
                    }

                    habilitarEdicao(true);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao consultar professor: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
        else if ("".equals(txtDisciplina.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Você deve digitar uma disciplina antes de atualizar", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else {
            if (rdoMasculino.isSelected()) {
                sexo = "M";
            }
            else if (rdoFeminino.isSelected()) {
                sexo = "F";
            }

            Professor p = new Professor();
            p.setId(Integer.parseInt(txtIdInfo.getText()));
            p.setNome(txtNome.getText().trim());
            p.setIdade(converterNumero(txtIdade.getText()));
            p.setSexo(sexo);
            p.setDisciplina(txtDisciplina.getText().trim());

            try {
                ProfessorDAO pDAO = new ProfessorDAO();

                if (pDAO.editar(p)) {
                    JOptionPane.showMessageDialog(null, "Professor atualizado", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Professor não existe mais no banco", "Alerta", JOptionPane.WARNING_MESSAGE);
                }

                limparFormulario();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar professor: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir? As matrículas deste professor também serão excluídas", "Exclusão", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                ProfessorDAO pDAO = new ProfessorDAO();
                pDAO.excluir(Integer.parseInt(txtIdInfo.getText()));
                limparFormulario();
                JOptionPane.showMessageDialog(null, "Professor excluído", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir professor: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.ButtonGroup btngSexo;
    private javax.swing.JLabel lblDisciplina;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdInfo;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblModificarProfessor;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JRadioButton rdoFeminino;
    private javax.swing.JRadioButton rdoMasculino;
    private javax.swing.JTextField txtDisciplina;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdInfo;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
