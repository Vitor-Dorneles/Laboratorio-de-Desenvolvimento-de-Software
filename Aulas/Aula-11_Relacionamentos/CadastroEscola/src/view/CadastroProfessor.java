package view;

import beans.Professor;
import dao.ProfessorDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CadastroProfessor extends javax.swing.JFrame {

    public CadastroProfessor() {
        initComponents();
        getRootPane().setDefaultButton(btnSalvar);
    }

    public int converterNumero(String texto) {
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    public void limparCampos() {
        txtNome.setText("");
        txtIdade.setText("");
        txtDisciplina.setText("");
        btngSexo.clearSelection();
        txtNome.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngSexo = new javax.swing.ButtonGroup();
        lblCadastroProfessor = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblIdade = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        rdoMasculino = new javax.swing.JRadioButton();
        rdoFeminino = new javax.swing.JRadioButton();
        lblDisciplina = new javax.swing.JLabel();
        txtDisciplina = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Professor");

        lblCadastroProfessor.setText("Cadastro de Professor");

        lblNome.setText("Nome:");

        lblIdade.setText("Idade:");

        lblSexo.setText("Sexo:");

        btngSexo.add(rdoMasculino);
        rdoMasculino.setText("Masculino");

        btngSexo.add(rdoFeminino);
        rdoFeminino.setText("Feminino");

        lblDisciplina.setText("Disciplina:");

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
                        .addComponent(lblCadastroProfessor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalvar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNome)
                                    .addComponent(lblIdade)
                                    .addComponent(lblSexo)
                                    .addComponent(lblDisciplina))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addComponent(lblCadastroProfessor)
                .addGap(18, 18, 18)
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
                .addComponent(btnSalvar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String sexo = "";

        if ("".equals(txtNome.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Você deve digitar um nome antes de salvar", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else if (converterNumero(txtIdade.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "A idade deve ser um número inteiro maior que zero", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else if (!rdoMasculino.isSelected() && !rdoFeminino.isSelected()) {
            JOptionPane.showMessageDialog(null, "Você deve selecionar um sexo antes de salvar", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else if ("".equals(txtDisciplina.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Você deve digitar uma disciplina antes de salvar", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else {
            if (rdoMasculino.isSelected()) {
                sexo = "M";
            }
            else if (rdoFeminino.isSelected()) {
                sexo = "F";
            }

            Professor p = new Professor();
            p.setNome(txtNome.getText().trim());
            p.setIdade(converterNumero(txtIdade.getText()));
            p.setSexo(sexo);
            p.setDisciplina(txtDisciplina.getText().trim());

            try {
                ProfessorDAO pDAO = new ProfessorDAO();
                pDAO.inserir(p);
                JOptionPane.showMessageDialog(null, "Professor adicionado com sucesso", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir professor: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup btngSexo;
    private javax.swing.JLabel lblCadastroProfessor;
    private javax.swing.JLabel lblDisciplina;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JRadioButton rdoFeminino;
    private javax.swing.JRadioButton rdoMasculino;
    private javax.swing.JTextField txtDisciplina;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
