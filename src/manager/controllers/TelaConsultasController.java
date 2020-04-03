package manager.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manager.database.DatabaseManager;
import manager.util.Log;
import org.apache.log4j.Logger;

public class TelaConsultasController {
    
    private static final Logger LOG = Logger.getLogger(TelaConsultasController.class);
    
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
    
    public ResultSet getResultSet(String query) throws SQLException{
        return manager.getResultSet(query);
    }
    
    public ResultSet getResultQuery(String tableName) throws SQLException{
        return manager.getResultSet(String.format("SELECT * FROM %s", tableName));
    }
    
    public ResultSet getResultProcedure(String procedureName) throws SQLException{
        return manager.getResultSet(String.format("CALL %s", procedureName));
    }
    
    public List<String> getProcedures(){
        return manager.getProcedures(manager.getCurrentDatabase());
    }
    
    public List<String> getTablesNames(){
        try{
            return manager.getTablesNames();
        }catch(SQLException e){
            String path = "manager.controllers.TelaConsultasController.getTablesNames()";
            Log.saveErrorLog(LOG, e, path);
        }
        return new ArrayList<>();
    }
}