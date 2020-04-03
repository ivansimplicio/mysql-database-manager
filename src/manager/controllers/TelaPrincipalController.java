package manager.controllers;

import java.awt.Component;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.JTextArea;
import manager.components.FileChooser;
import manager.database.DatabaseManager;
import manager.util.File;

public class TelaPrincipalController {
    
    private static TelaPrincipalController controller;
    private DatabaseManager manager = null;

    private TelaPrincipalController(DatabaseManager manager){
        this.manager = manager;
    }
    
    public static TelaPrincipalController getInstance(DatabaseManager manager){
        if(controller == null){
            controller = new TelaPrincipalController(manager);
        }
        return controller;
    }
    
    public DatabaseManager getDatabaseManager(){
        return this.manager;
    }

    public void useDatabase(String database){
        manager.insertQuery(String.format("USE %s", database));
    }

    public String submitManyQueries(String sql) throws SQLException {
        String result = "TOTAL DE COMANDOS INSERIDOS: %d\nSUBMETIDOS: %d\nFALHAS: %d";
        Queue<String> queue = new LinkedList<>();
        String[] queries = sql.split(";");
        int queriesCount = queries.length;
        int queriesSubmitted = 0;
        queue.addAll(Arrays.asList(queries));
        for (int i = 0; i < queriesCount; i++) {
            String query = queue.poll();
            if (manager.insertQuery(query)) {
                queriesSubmitted++;
            } else {
                String message = String.format(result, queriesCount, queriesSubmitted,
                                                queriesCount-queriesSubmitted);
                throw new SQLException(message);
            }
        }
        return String.format(result, queriesCount, queriesSubmitted, queriesCount-queriesSubmitted);
    }
    
    public void submitQuery(String sql) throws SQLException{
        if(!manager.insertQuery(sql)){
            throw new SQLException("Comando Incorreto!");
        }
    }
    
    public String getCurrentUser(){
        return manager.getCurrentUser();
    }
    
    public String getCurrentDatabase(){
        return manager.getCurrentDatabase();
    }
    
    public List<String> getDatabasesNames(){
        return manager.getDatabasesNames();
    }
    
    public void close(){
        controller = null;
        manager.close();
    }
    
    //apenas para verificar se algum banco de dados está aberto,
    //ou o banco de dados não possui tabelas, lançando assim uma Exception.
    public void validateDatabase() throws SQLException{
        try{
            manager.getTablesNames(); 
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
    }
    
    public String saveFile(Component component, String content) throws IOException{
        String path = FileChooser.saveFile(component);
        String extension = ".sql";
        if (!path.isEmpty()) {
            if (!path.endsWith(extension)) {
                path = path.concat(extension);
            }
            File.Write(path, content);
        }
        return path;
    }
    
    public void openFile(Component component, JTextArea textArea) throws IOException{
        String path = FileChooser.openFile(component);
        if(!path.isEmpty()){
            String content = File.Read(path);
            textArea.setText(content);
        }
    }
}