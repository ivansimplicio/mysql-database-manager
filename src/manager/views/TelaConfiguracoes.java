package manager.views;

import manager.system.PreferencesManager;
import manager.views.dialog.OptionPane;

public class TelaConfiguracoes extends javax.swing.JFrame {
    
    private PreferencesManager prefsManager = null;
    private String currentUser = "";
    
    public TelaConfiguracoes(PreferencesManager prefsManager, String currentUser) {
        initComponents();
        this.prefsManager = prefsManager;
        this.currentUser = currentUser;
        startComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    
    private TelaConfiguracoes(){
        
    }
    
    private void startComponents(){
        area_texto.setEnabled(false);
        area_texto.setText(this.prefsManager.getStandardCommand());
        label_user.setText(this.currentUser);
        checkBox1.setSelected(this.prefsManager.isClearTextArea());
        checkBox2.setSelected(this.prefsManager.isMultiQueries());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botao_salvar = new javax.swing.JButton();
        botao_voltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_texto = new javax.swing.JTextArea();
        botao_alterarComando = new javax.swing.JToggleButton();
        checkBox1 = new javax.swing.JCheckBox();
        checkBox2 = new javax.swing.JCheckBox();
        label_usuarioLogado = new javax.swing.JLabel();
        label_user = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações");

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 300));

        botao_salvar.setText("Salvar");
        botao_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_salvarActionPerformed(evt);
            }
        });

        botao_voltar.setText("Voltar");
        botao_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_voltarActionPerformed(evt);
            }
        });

        area_texto.setColumns(20);
        area_texto.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        area_texto.setRows(5);
        jScrollPane1.setViewportView(area_texto);

        botao_alterarComando.setText("Alterar Comando");
        botao_alterarComando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_alterarComandoActionPerformed(evt);
            }
        });

        checkBox1.setText("Limpar tela após submissão de comandos");

        checkBox2.setText("Permitir submissão de mais um comando por vez");

        label_usuarioLogado.setText("Usuário logado:");

        label_user.setText("     ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBox2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(checkBox1)
                                .addGap(45, 45, 45)
                                .addComponent(label_usuarioLogado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_user, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(botao_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botao_alterarComando)
                .addGap(52, 52, 52)
                .addComponent(botao_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBox1)
                    .addComponent(label_usuarioLogado)
                    .addComponent(label_user))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_salvar)
                    .addComponent(botao_voltar)
                    .addComponent(botao_alterarComando))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_voltarActionPerformed
       dispose();
    }//GEN-LAST:event_botao_voltarActionPerformed

    private void botao_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_salvarActionPerformed
        prefsManager.savePreferences(checkBox1.isSelected(), checkBox2.isSelected(), area_texto.getText());
        OptionPane.showInfoDialog("", "Configurações Salvas!");
        dispose();
    }//GEN-LAST:event_botao_salvarActionPerformed

    private void botao_alterarComandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_alterarComandoActionPerformed
        if(botao_alterarComando.isSelected())
            area_texto.setEnabled(true);
        else
            area_texto.setEnabled(false);
    }//GEN-LAST:event_botao_alterarComandoActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConfiguracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConfiguracoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_texto;
    private javax.swing.JToggleButton botao_alterarComando;
    private javax.swing.JButton botao_salvar;
    private javax.swing.JButton botao_voltar;
    private javax.swing.JCheckBox checkBox1;
    private javax.swing.JCheckBox checkBox2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_user;
    private javax.swing.JLabel label_usuarioLogado;
    // End of variables declaration//GEN-END:variables
}