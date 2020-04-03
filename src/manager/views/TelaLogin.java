package manager.views;

import java.sql.SQLException;
import manager.database.Connection;
import manager.database.DatabaseManager;
import manager.enums.SystemMessages;
import manager.system.PreferencesManager;
import manager.views.dialog.Dialog;
import manager.views.dialog.OptionPane;
import org.apache.log4j.PropertyConfigurator;

public class TelaLogin extends javax.swing.JFrame {
    
    private PreferencesManager prefsManager = null;
    
    public TelaLogin() {
        initComponents();
        prefsManager = PreferencesManager.getInstance();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        checkBox_salvarInformacoes.setSelected(false);
        campo_ip.setText(prefsManager.getHost());
        campo_bd.setText(prefsManager.getDatabase());
        campo_login.setText(prefsManager.getUsername());
        campo_senha.setText(prefsManager.getPassword());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        texto_ip = new javax.swing.JLabel();
        texto_bd = new javax.swing.JLabel();
        texto_login = new javax.swing.JLabel();
        texto_senha = new javax.swing.JLabel();
        campo_ip = new javax.swing.JTextField();
        campo_bd = new javax.swing.JTextField();
        campo_login = new javax.swing.JTextField();
        botao_entrar = new javax.swing.JButton();
        botao_sair = new javax.swing.JButton();
        campo_senha = new javax.swing.JPasswordField();
        checkBox_salvarInformacoes = new javax.swing.JCheckBox();
        menuBar = new javax.swing.JMenuBar();
        menu_Sobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conectar");

        texto_ip.setText("Endereço IP:");

        texto_bd.setText("Banco de dados:");

        texto_login.setText("Login:");

        texto_senha.setText("Senha:");

        botao_entrar.setText("Entrar");
        botao_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_entrarActionPerformed(evt);
            }
        });

        botao_sair.setText("Sair");
        botao_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_sairActionPerformed(evt);
            }
        });

        checkBox_salvarInformacoes.setText("Salvar Informações");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texto_bd)
                                    .addComponent(texto_ip)
                                    .addComponent(texto_login))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campo_bd, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                    .addComponent(campo_ip, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                    .addComponent(campo_login)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(texto_senha)
                                .addGap(64, 64, 64)
                                .addComponent(campo_senha))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(botao_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(botao_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(checkBox_salvarInformacoes)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_ip)
                    .addComponent(campo_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_bd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_bd))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_login))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_senha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBox_salvarInformacoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_entrar)
                    .addComponent(botao_sair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menu_Sobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/information-bold.png"))); // NOI18N
        menu_Sobre.setText("Sobre");
        menu_Sobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_SobreMouseClicked(evt);
            }
        });
        menuBar.add(menu_Sobre);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_sairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botao_sairActionPerformed

    private void botao_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_entrarActionPerformed
        try{
            Connection con = Connection.getInstance(campo_ip.getText(), campo_bd.getText(), campo_login.getText(), new String(campo_senha.getPassword()));
            OptionPane.showInfoDialog("Conectado!", "CONECTADO COM SUCESSO!");
            if(checkBox_salvarInformacoes.isSelected()){
                prefsManager.saveLogin(campo_ip.getText(), campo_bd.getText(), campo_login.getText(), campo_senha.getText());
            }
            new TelaPrincipal(DatabaseManager.getInstance(con), prefsManager);
            dispose();
        }catch(SQLException e){
            if(OptionPane.showSelectDialog(e.getMessage()) == 1){
                Dialog dialog = new Dialog(this, true);
                dialog.setLabelTitle(SystemMessages.LOGIN_ERROR.getTitle());
                dialog.setLabelMessage(SystemMessages.LOGIN_ERROR.getMessage());
                dialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_botao_entrarActionPerformed

    private void menu_SobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_SobreMouseClicked
        Dialog dialog = new Dialog(this, true);
        dialog.setLabelTitle(SystemMessages.SYSTEM_INFO.getTitle());
        dialog.setLabelMessage(SystemMessages.SYSTEM_INFO.getMessage());
        dialog.setVisible(true);
    }//GEN-LAST:event_menu_SobreMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        PropertyConfigurator.configure("src/log4j.properties");
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_entrar;
    private javax.swing.JButton botao_sair;
    private javax.swing.JTextField campo_bd;
    private javax.swing.JTextField campo_ip;
    private javax.swing.JTextField campo_login;
    private javax.swing.JPasswordField campo_senha;
    private javax.swing.JCheckBox checkBox_salvarInformacoes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menu_Sobre;
    private javax.swing.JLabel texto_bd;
    private javax.swing.JLabel texto_ip;
    private javax.swing.JLabel texto_login;
    private javax.swing.JLabel texto_senha;
    // End of variables declaration//GEN-END:variables
}