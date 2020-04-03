package manager.views;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import manager.database.DatabaseManager;
import manager.controllers.TelaPrincipalController;
import manager.system.PreferencesManager;
import manager.components.ComboBox;
import manager.enums.SystemMessages;
import manager.views.dialog.Dialog;
import manager.views.dialog.OptionPane;

public class TelaPrincipal extends javax.swing.JFrame {
    
    private PreferencesManager prefsManager;
    private TelaPrincipalController controller = null;
    
    public TelaPrincipal(DatabaseManager manager, PreferencesManager prefsManager) {
        initComponents();
        this.prefsManager = prefsManager;
        startComponents(manager);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    private TelaPrincipal(){
        
    }
    
    private void startComponents(DatabaseManager manager) {
        controller = TelaPrincipalController.getInstance(manager);
        setUsingDatabase(controller.getCurrentDatabase());
        List<String> databases = controller.getDatabasesNames();
        ComboBox.load(comboBox_schemas, databases, true);
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
        menu_arquivo = new javax.swing.JMenu();
        menuItem_salvar = new javax.swing.JMenuItem();
        menuItem_abrir = new javax.swing.JMenuItem();
        menu_configuracoes = new javax.swing.JMenu();
        menu_sobre = new javax.swing.JMenu();
        menu_logout = new javax.swing.JMenu();

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

        menu_arquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/files-bold.png"))); // NOI18N
        menu_arquivo.setText("Arquivo");

        menuItem_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/save-file-bold.png"))); // NOI18N
        menuItem_salvar.setText("Salvar Query");
        menuItem_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_salvarActionPerformed(evt);
            }
        });
        menu_arquivo.add(menuItem_salvar);

        menuItem_abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/open-file-bold.png"))); // NOI18N
        menuItem_abrir.setText("Abrir Query");
        menuItem_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_abrirActionPerformed(evt);
            }
        });
        menu_arquivo.add(menuItem_abrir);

        menuBar.add(menu_arquivo);

        menu_configuracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings-bold.png"))); // NOI18N
        menu_configuracoes.setText("Configurações");
        menu_configuracoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_configuracoesMouseClicked(evt);
            }
        });
        menuBar.add(menu_configuracoes);

        menu_sobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/information-bold.png"))); // NOI18N
        menu_sobre.setText("Sobre");
        menu_sobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_sobreMouseClicked(evt);
            }
        });
        menuBar.add(menu_sobre);

        menu_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/logout-bold.png"))); // NOI18N
        menu_logout.setText("Logout");
        menu_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_logoutMouseClicked(evt);
            }
        });
        menuBar.add(menu_logout);

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

    private void setUsingDatabase(String database){
        label_schemaEmUso.setText("Database em uso: " + ((database != null) ? database : ""));
    }
    
    private void botao_submeterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_submeterActionPerformed
        String query = area_texto.getText();
        if (!query.trim().isEmpty()) {
            if (prefsManager.isMultiQueries()) {
                try {
                    String result = controller.submitManyQueries(query);
                    OptionPane.showInfoDialog("INFORMAÇÕES SOBRE AS SUBMISSÕES", result);
                    if (prefsManager.isClearTextArea()) {
                        clearTextArea();
                    }
                } catch (SQLException e) {
                    OptionPane.showErrorDialog("INFORMAÇÕES SOBRE AS SUBMISSÕES", e.getMessage());
                }
            } else {
                try {
                    controller.submitQuery(query);
                    OptionPane.showInfoDialog("SUCESSO!", "COMANDO SUBMETIDO!");
                    if (prefsManager.isClearTextArea()) {
                        clearTextArea();
                    }
                } catch (SQLException e) {
                    OptionPane.showErrorDialog("FALHA!", e.getMessage());
                }
            }
            List<String> databases = controller.getDatabasesNames();
            ComboBox.load(comboBox_schemas, databases, true);
        } else {
            OptionPane.showWarnDialog("", "NENHUM COMANDO INSERIDO!");
        }
        setUsingDatabase(controller.getCurrentDatabase());
    }//GEN-LAST:event_botao_submeterActionPerformed

    private void botao_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_limparActionPerformed
        clearTextArea();
    }//GEN-LAST:event_botao_limparActionPerformed

    private void botao_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_inserirActionPerformed
       area_texto.setText(prefsManager.getStandardCommand());
    }//GEN-LAST:event_botao_inserirActionPerformed

    private void botao_verDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_verDadosActionPerformed
        try {
            controller.validateDatabase();
            new TelaConsultas(controller.getDatabaseManager());
        } catch (SQLException e) {
            OptionPane.showErrorDialog("", e.getMessage());
        }
    }//GEN-LAST:event_botao_verDadosActionPerformed

    private void menu_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_logoutMouseClicked
        controller.close();
        new TelaLogin();
        dispose();
    }//GEN-LAST:event_menu_logoutMouseClicked

    private void botao_usar_schemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_usar_schemaActionPerformed
        if (comboBox_schemas.getItemCount() == 1) {
            OptionPane.showErrorDialog("ERRO", "NENHUM BANCO DE DADOS ENCONTRADO!");
        } else if (comboBox_schemas.getSelectedItem() == "") {
            OptionPane.showWarnDialog("AVISO", "SELECIONE UM BANCO DE DADOS!");
        } else {
            String selectedDatabase = (String) comboBox_schemas.getSelectedItem();
            controller.useDatabase(selectedDatabase);
            setUsingDatabase(selectedDatabase);
            OptionPane.showInfoDialog("BANCO DE DADOS SELECIONADO", "USANDO: " + selectedDatabase);
        }
    }//GEN-LAST:event_botao_usar_schemaActionPerformed

    private void menu_configuracoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_configuracoesMouseClicked
        new TelaConfiguracoes(prefsManager, controller.getCurrentUser());
    }//GEN-LAST:event_menu_configuracoesMouseClicked

    private void menu_sobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_sobreMouseClicked
        Dialog dialog = new Dialog(this, true);
        dialog.setLabelTitle(SystemMessages.SYSTEM_INFO.getTitle());
        dialog.setLabelMessage(SystemMessages.SYSTEM_INFO.getMessage());
        dialog.setVisible(true);
    }//GEN-LAST:event_menu_sobreMouseClicked

    private void menuItem_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_salvarActionPerformed
        try{
            String resultPath = controller.saveFile(this, area_texto.getText());
            if(!resultPath.isEmpty()){
                String message = "Path: "+resultPath;
                OptionPane.showInfoDialog("Arquivo criado", message);
            }
        }catch(IOException e){
            OptionPane.showErrorDialog("ERRO", e.getMessage());
        }
    }//GEN-LAST:event_menuItem_salvarActionPerformed

    private void menuItem_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_abrirActionPerformed
        try{
            controller.openFile(this, area_texto);
        }catch(IOException e){
            OptionPane.showErrorDialog("ERRO", e.getMessage());
        }
    }//GEN-LAST:event_menuItem_abrirActionPerformed
    
    public void clearTextArea(){
        area_texto.setText("");
    }
    
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
    private javax.swing.JMenuItem menuItem_abrir;
    private javax.swing.JMenuItem menuItem_salvar;
    private javax.swing.JMenu menu_arquivo;
    private javax.swing.JMenu menu_configuracoes;
    private javax.swing.JMenu menu_logout;
    private javax.swing.JMenu menu_sobre;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables
}