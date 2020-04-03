package manager.views;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import manager.controllers.TelaConsultasController;
import manager.database.DatabaseManager;
import manager.components.ComboBox;
import manager.components.TableModel;
import manager.enums.SystemMessages;
import manager.enums.QueryType;
import manager.views.dialog.Dialog;
import manager.views.dialog.OptionPane;

public class TelaConsultas extends javax.swing.JFrame {

    private QueryType queryType;
    private TelaConsultasController controller;
    
    public TelaConsultas(DatabaseManager manager) {
        initComponents();
        queryType = QueryType.CONSULT_TABLES;
        controller = TelaConsultasController.getInstance(manager);
        startComponents();
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }
    
    private TelaConsultas(){
        
    }
    
    private void startComponents(){
        List<String> procedures = controller.getProcedures();
        ComboBox.load(comboBox_procedures, procedures, false);
        List<String> tables = controller.getTablesNames();
        ComboBox.load(comboBox_tabelas, tables, false);
        area_texto.setText("Exemplo de consulta:\nSELECT * FROM tableX");
        area_texto.setEnabled(false);
        comboBox_procedures.setEnabled(false); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoes_busca = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        texto_ComboBox = new javax.swing.JLabel();
        botao_consultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        comboBox_tabelas = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        area_texto = new javax.swing.JTextArea();
        labal_consultaPersonalizada = new javax.swing.JLabel();
        comboBox_procedures = new javax.swing.JComboBox<>();
        label_procedures = new javax.swing.JLabel();
        radioButton_inserirComando = new javax.swing.JRadioButton();
        radioButton_procedures = new javax.swing.JRadioButton();
        radioButton_tabelas = new javax.swing.JRadioButton();
        botao_info = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Executar Querys");

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 370));

        texto_ComboBox.setText("Tabelas:");

        botao_consultar.setText("Consultar");
        botao_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_consultarActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabela);

        area_texto.setColumns(20);
        area_texto.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        area_texto.setRows(5);
        jScrollPane2.setViewportView(area_texto);

        labal_consultaPersonalizada.setText("Modos de consulta:");

        label_procedures.setText("Procedures:");

        grupoBotoes_busca.add(radioButton_inserirComando);
        radioButton_inserirComando.setText("Inserir comando");
        radioButton_inserirComando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButton_inserirComandoActionPerformed(evt);
            }
        });

        grupoBotoes_busca.add(radioButton_procedures);
        radioButton_procedures.setText("Procedures");
        radioButton_procedures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButton_proceduresActionPerformed(evt);
            }
        });

        grupoBotoes_busca.add(radioButton_tabelas);
        radioButton_tabelas.setSelected(true);
        radioButton_tabelas.setText("Tabelas");
        radioButton_tabelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButton_tabelasActionPerformed(evt);
            }
        });

        botao_info.setText("Informações");
        botao_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_infoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_procedures)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBox_procedures, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(texto_ComboBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(comboBox_tabelas, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioButton_inserirComando)
                    .addComponent(radioButton_procedures)
                    .addComponent(radioButton_tabelas)
                    .addComponent(labal_consultaPersonalizada)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(botao_info, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botao_consultar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labal_consultaPersonalizada, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioButton_inserirComando)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioButton_procedures)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioButton_tabelas)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_procedures)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBox_procedures, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botao_info)))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox_tabelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_ComboBox)
                    .addComponent(botao_consultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_consultarActionPerformed
        ResultSet resultQuery = null;
        boolean load = true;
        try {
            switch (queryType) {
                case INSERT_QUERY:
                    resultQuery = controller.getResultSet(area_texto.getText());
                    break;
                case CONSULT_PROCEDURES:
                    Object obj = comboBox_procedures.getSelectedItem();
                    if(obj != null){
                        resultQuery = controller.getResultProcedure(obj.toString());
                    }else{
                        OptionPane.showWarnDialog("AVISO", "SELECIONE UM PROCEDIMENTO");
                        load = false;
                    }
                    break;
                case CONSULT_TABLES:
                    resultQuery = controller.getResultQuery(comboBox_tabelas.getSelectedItem().toString());
                    break;
            }
            if(load){
                TableModel.load(tabela, resultQuery);
            }
        } catch (SQLException e) {
            String errorMessage = "Ocorreu um erro ao processar a consulta.\nVerifique a query submetida.";
            if (OptionPane.showSelectDialog(errorMessage) == 1) {
                createDialog();
            }
        }
    }//GEN-LAST:event_botao_consultarActionPerformed

    private void radioButton_inserirComandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButton_inserirComandoActionPerformed
        area_texto.setEnabled(true);
        comboBox_procedures.setEnabled(false);
        comboBox_tabelas.setEnabled(false);
        queryType = QueryType.INSERT_QUERY;
    }//GEN-LAST:event_radioButton_inserirComandoActionPerformed

    private void radioButton_proceduresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButton_proceduresActionPerformed
        area_texto.setEnabled(false);
        comboBox_procedures.setEnabled(true);
        comboBox_tabelas.setEnabled(false);
        queryType = QueryType.CONSULT_PROCEDURES;
    }//GEN-LAST:event_radioButton_proceduresActionPerformed

    private void radioButton_tabelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButton_tabelasActionPerformed
        area_texto.setEnabled(false);
        comboBox_procedures.setEnabled(false);
        comboBox_tabelas.setEnabled(true);
        queryType = QueryType.CONSULT_TABLES;
    }//GEN-LAST:event_radioButton_tabelasActionPerformed

    private void botao_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_infoActionPerformed
        createDialog();
    }//GEN-LAST:event_botao_infoActionPerformed
    
    private void createDialog(){
        Dialog dialog = new Dialog(this, true);
        dialog.setLabelTitle(SystemMessages.QUERY_ERROR.getTitle());
        dialog.setLabelMessage(SystemMessages.QUERY_ERROR.getMessage());
        dialog.setVisible(true);
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
            java.util.logging.Logger.getLogger(TelaConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_texto;
    private javax.swing.JButton botao_consultar;
    private javax.swing.JButton botao_info;
    private javax.swing.JComboBox<String> comboBox_procedures;
    private javax.swing.JComboBox<String> comboBox_tabelas;
    private javax.swing.ButtonGroup grupoBotoes_busca;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labal_consultaPersonalizada;
    private javax.swing.JLabel label_procedures;
    private javax.swing.JRadioButton radioButton_inserirComando;
    private javax.swing.JRadioButton radioButton_procedures;
    private javax.swing.JRadioButton radioButton_tabelas;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel texto_ComboBox;
    // End of variables declaration//GEN-END:variables
}