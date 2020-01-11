package manager.controllers;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import manager.database.DatabaseManager;

public class TelaPrincipalController {
    
    private static TelaPrincipalController controller;
    private DatabaseManager dbManager = null;

    private TelaPrincipalController(DatabaseManager manager){
        this.dbManager = manager;
    }
    
    public static TelaPrincipalController getInstance(DatabaseManager manager){
        if(controller == null){
            controller = new TelaPrincipalController(manager);
        }
        return controller;
    }
    
    public DatabaseManager getDatabaseManager(){
        return this.dbManager;
    }

    public void useDatabase(String database){
        dbManager.inserirComando(String.format("USE %s", database));
    }

    public String submeterMuitasInstrucoes(String sql) throws SQLException {
        String result = "TOTAL DE COMANDOS INSERIDOS: %d\nSUBMETIDOS: %d\nFALHAS: %d";
        
        Queue<String> filaComandos = new LinkedList<>();
        String[] comandos = sql.split(";");
        int quantidadeComandos = comandos.length;
        int comandosSubmetidos = 0;
        filaComandos.addAll(Arrays.asList(comandos));
        for (int i = 0; i < quantidadeComandos; i++) {
            String comando = filaComandos.poll();
            if (dbManager.inserirComando(comando)) {
                comandosSubmetidos++;
            } else {
                String message = String.format(result,quantidadeComandos, comandosSubmetidos,
                                                quantidadeComandos-comandosSubmetidos);
                throw new SQLException(message);
            }
        }
        return String.format(result,quantidadeComandos, comandosSubmetidos, quantidadeComandos-comandosSubmetidos);
    }
    
    public void submeterUmComando(String sql) throws SQLException{
        if(!dbManager.inserirComando(sql)){
            throw new SQLException("Comando Incorreto!");
        }
    }
    
    public String getCurrentUser(){
        return dbManager.getCurrentUser();
    }
    
    public String getCurrentDatabase(){
        return dbManager.getCurrentDatabase();
    }
    
    public List<String> getDatabasesNames(){
        return dbManager.getDatabasesNames();
    }
    
    public void encerrarConexao(){
        controller = null;
        dbManager.fecharConexao();
    }
    
    //apenas para verificar se algum schema está aberto, ou o schema não possui tabelas, lançando assim uma Exception.
    public void verificarDados() throws Exception{
        try{
            dbManager.getTablesNames(); 
        }catch(RuntimeException e){
            throw new Exception(e.getMessage());
        }
    }
}