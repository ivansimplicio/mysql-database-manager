package manager.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import manager.database.DatabaseManager;
import manager.controllers.TelaPrincipalController;
import manager.system.Configuracoes;
import manager.components.ComboBox;
import manager.enums.SystemMessages;
import manager.views.dialog.Dialog;

public class TelaPrincipal extends javax.swing.JFrame {
    
    private Configuracoes configs = null;
    private TelaPrincipalController telaPrincipalController = null;
    
    public TelaPrincipal(DatabaseManager gerenciador) {
        initComponents();
        iniciaComponentes(gerenciador);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    private TelaPrincipal(){
        
    }
    
    private void iniciaComponentes(DatabaseManager manager) {
        configs = Configuracoes.getInstance();
        telaPrincipalController = TelaPrincipalController.getInstance(manager);
        label_schemaEmUso.setText("Schema em uso: "+telaPrincipalController.getCurrentDatabase());
        List<String> schemas = telaPrincipalController.getDatabasesNames();
        ComboBox.load(comboBox_schemas, schemas, true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        botao_submeter = new javax.swing.JButton();
        scrollPanel = new javax.swing.JScrollPane();
        area_texto = new javax.swing.JTextArea();
        botao_limpar = new javax.swing.JButton();
        botao_inserir = new javax.swing.JButton();
        botao_verDados = new javax.swing.JButton();
        label_listaBancos = new javax.swing.JLabel();
        botao_usar_schema = new javax.swing.JButton();
        comboBox_schemas = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        label_inserirComandos = new javax.swing.JLabel();
        label_schemaEmUso = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menu_configuracoes = new javax.swing.JMenu();
        menu_Sobre = new javax.swing.JMenu();
        menu_Logout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MySQL Database Manager");
        setResizable(false);

        painelPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painelPrincipal.setPreferredSize(new java.awt.Dimension(600, 350));

        botao_submeter.setText("Submeter");
        botao_submeter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_submeterActionPerformed(evt);
            }
        });

        area_texto.setColumns(20);
        area_texto.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        area_texto.setRows(5);
        scrollPanel.setViewportView(area_texto);

        botao_limpar.setText("Limpar");
        botao_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_limparActionPerformed(evt);
            }
        });

        botao_inserir.setText("Inserir Padrão");
        botao_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_inserirActionPerformed(evt);
            }
        });

        botao_verDados.setText("Ver Dados");
        botao_verDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_verDadosActionPerformed(evt);
            }
        });

        label_listaBancos.setText("Selecionar Schema existente:");

        botao_usar_schema.setText("Usar");
        botao_usar_schema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_usar_schemaActionPerformed(evt);
            }
        });

        label_inserirComandos.setText("INSERIR COMANDOS:");

        label_schemaEmUso.setText("                                                   ");

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanel)
                .addContainerGap())
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(botao_submeter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(botao_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(botao_inserir)
                .addGap(56, 56, 56)
                .addComponent(botao_verDados, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_listaBancos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBox_schemas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(botao_usar_schema, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_inserirComandos)
                .addGap(174, 174, 174)
                .addComponent(label_schemaEmUso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_listaBancos)
                    .addComponent(botao_usar_schema)
                    .addComponent(comboBox_schemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_inserirComandos)
                    .addComponent(label_schemaEmUso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_limpar)
                    .addComponent(botao_submeter)
                    .addComponent(botao_inserir)
                    .addComponent(botao_verDados))
                .addContainerGap())
        );

        menu_configuracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/manager/icons/bullet_wrench.png"))); // NOI18N
        menu_configuracoes.setText("Configurações");
        menu_configuracoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_configuracoesMouseClicked(evt);
            }
        });
        menuBar.add(menu_configuracoes);

        menu_Sobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/manager/icons/information.png"))); // NOI18N
        menu_Sobre.setText("Sobre");
        menu_Sobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_SobreMouseClicked(evt);
            }
        });
        menuBar.add(menu_Sobre);

        menu_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/manager/icons/logout-button-16b.png"))); // NOI18N
        menu_Logout.setText("Logout");
        menu_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_LogoutMouseClicked(evt);
            }
        });
        menuBar.add(menu_Logout);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_submeterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_submeterActionPerformed
        String comandoSQL = getTextArea_Texto();
        if (!comandoSQL.trim().isEmpty()) {
            if (configs.checkBox2Marked()) {
                try {
                    String result = telaPrincipalController.submeterMuitasInstrucoes(comandoSQL);
                    JOptionPane.showMessageDialog(null, result, "INFORMAÇÕES SOBRE AS SUBMISSÕES", JOptionPane.INFORMATION_MESSAGE);
                    if (configs.checkBox1Marked()) {
                        limparAreaTexto();
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "INFORMAÇÕES SOBRE AS SUBMISSÕES", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                try {
                    telaPrincipalController.submeterUmComando(comandoSQL);
                    JOptionPane.showMessageDialog(null, "COMANDO SUBMETIDO!", "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
                    if (configs.checkBox1Marked()) {
                        limparAreaTexto();
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "FALHA!", JOptionPane.ERROR_MESSAGE);
                }
            }
            List<String> schemas = telaPrincipalController.getDatabasesNames();
            ComboBox.load(comboBox_schemas, schemas, true);
        } else {
            JOptionPane.showMessageDialog(null, "NENHUM COMANDO INSERIDO!", "", JOptionPane.WARNING_MESSAGE);
        }
        label_schemaEmUso.setText("Schema em uso: " + telaPrincipalController.getCurrentDatabase());
    }//GEN-LAST:event_botao_submeterActionPerformed

    private void botao_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_limparActionPerformed
        limparAreaTexto();
    }//GEN-LAST:event_botao_limparActionPerformed

    private void botao_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_inserirActionPerformed
       area_texto.setText(configs.getComandoPadrao());
    }//GEN-LAST:event_botao_inserirActionPerformed

    private void botao_verDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_verDadosActionPerformed
        try {
            telaPrincipalController.verificarDados();
            new TelaConsultas(telaPrincipalController.getDatabaseManager());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botao_verDadosActionPerformed

    private void menu_LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_LogoutMouseClicked
        telaPrincipalController.encerrarConexao();
        new TelaLogin();
        dispose();
    }//GEN-LAST:event_menu_LogoutMouseClicked

    private void botao_usar_schemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_usar_schemaActionPerformed
        if (comboBox_schemas.getItemCount() == 1) {
            JOptionPane.showMessageDialog(null, "NENHUM SCHEMA ENCONTRADO!", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else if (comboBox_schemas.getSelectedItem() == "") {
            JOptionPane.showMessageDialog(null, "SELECIONE UM SCHEMA!", "AVISO", JOptionPane.WARNING_MESSAGE);
        } else {
            String databaseUsing = (String) comboBox_schemas.getSelectedItem();
            telaPrincipalController.useDatabase(databaseUsing);
            label_schemaEmUso.setText("Schema em uso: " + databaseUsing);
            JOptionPane.showMessageDialog(null, "SCHEMA EM USO: " + databaseUsing, "SCHEMA SELECIONADO", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botao_usar_schemaActionPerformed

    private void menu_configuracoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_configuracoesMouseClicked
        new TelaConfiguracoes(configs, telaPrincipalController.getCurrentUser());
    }//GEN-LAST:event_menu_configuracoesMouseClicked

    private void menu_SobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_SobreMouseClicked
        Dialog dialog = new Dialog(this, true);
        dialog.setLabelTitle(SystemMessages.SYSTEM_INFO.getTitle());
        dialog.setLabelMessage(SystemMessages.SYSTEM_INFO.getMessage());
        dialog.setVisible(true);
    }//GEN-LAST:event_menu_SobreMouseClicked
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    
    public String getTextArea_Texto(){
        return area_texto.getText();
    }
    
    public void setTextArea_Texto(String text){
        area_texto.setText(area_texto.getText().concat(text));
    }
    
    public void limparAreaTexto(){
        area_texto.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_texto;
    private javax.swing.JButton botao_inserir;
    private javax.swing.JButton botao_limpar;
    private javax.swing.JButton botao_submeter;
    private javax.swing.JButton botao_usar_schema;
    private javax.swing.JButton botao_verDados;
    private javax.swing.JComboBox<String> comboBox_schemas;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_inserirComandos;
    private javax.swing.JLabel label_listaBancos;
    private javax.swing.JLabel label_schemaEmUso;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menu_Logout;
    private javax.swing.JMenu menu_Sobre;
    private javax.swing.JMenu menu_configuracoes;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables
}