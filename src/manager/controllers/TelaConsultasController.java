package manager.controllers;

import java.sql.ResultSet;
import java.util.List;
import manager.database.DatabaseManager;

public class TelaConsultasController {
    
    private static TelaConsultasController controller;
    private final DatabaseManager manager;
    
    private TelaConsultasController(DatabaseManager manager){
        this.manager = manager;
    }
    
    public static TelaConsultasController getInstance(DatabaseManager manager){
        if(controller == null){
            controller = new TelaConsultasController(manager);
        }
        return controller;
    }
    
    public ResultSet getResultSet(String query) throws Exception{
        return manager.getResultSet(query);
    }
    
    public ResultSet getResultQuery(String tableName) throws Exception{
        return manager.getResultSet(String.format("SELECT * FROM %s", tableName));
    }
    
    public ResultSet getResultProcedure(String procedureName) throws Exception{
        return manager.getResultSet(String.format("CALL %s", procedureName));
    }
    
    public List<String> getExistingProcedures(){
        return manager.getExistingProcedures(manager.getCurrentDatabase());
    }
    
    public List<String> getTablesNames(){
        return manager.getTablesNames();
    }
}