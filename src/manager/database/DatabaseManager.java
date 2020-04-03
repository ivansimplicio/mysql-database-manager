package manager.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manager.util.Log;
import org.apache.log4j.Logger;

public class DatabaseManager {
    
    private static final Logger LOG = Logger.getLogger(DatabaseManager.class);

    private static DatabaseManager manager;
    private final Connection con;

    private DatabaseManager(Connection con) {
        this.con = con;
    }

    public static DatabaseManager getInstance(Connection con) {
        if (manager == null) {
            manager = new DatabaseManager(con);
        }
        return manager;
    }

    public void close() {
        this.con.close();
        manager = null;
    }
    
    public boolean insertQuery(String sql) {
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public ResultSet getResultSet(String sql) throws SQLException {
        ResultSet rs = null;
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            throw new SQLException("COMANDO INCORRETO!");
        }
        return rs;
    }

    public List<String> getTablesNames() throws SQLException {
        String sql = "SHOW TABLES";
        List<String> tables = new ArrayList<>();
        try {
            ResultSet rs = this.getResultSet(sql);
            while (rs.next()) {
                tables.add(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new SQLException("NENHUM BANCO DE DADOS ABERTO!");
        }
        if (tables.isEmpty()) {
            throw new SQLException("O BANCO DE DADOS NÃO POSSUI TABELAS!");
        }
        return tables;
    }

    public List<String> getProcedures(String database) {
        String sql = String.format("SHOW PROCEDURE STATUS WHERE db = '%s'", database);
        List<String> procedures = new ArrayList<>();
        try {
            ResultSet rs = this.getResultSet(sql);
            while (rs.next()) {
                procedures.add(rs.getString("Name"));
            }
        } catch (SQLException e) {
            String path = "manager.database.DatabaseManager.getProcedures(String)";
            Log.saveErrorLog(LOG, e, path);
        }
        return procedures;
    }

    public List<String> getDatabasesNames() {
        String sql = "SHOW DATABASES";
        List<String> databases = new ArrayList<>();
        try {
            ResultSet rs = this.getResultSet(sql);
            while (rs.next()) {
                databases.add(rs.getString(1));
            }
        } catch (SQLException e) {
            String path = "manager.database.DatabaseManager.getDatabasesNames()";
            Log.saveErrorLog(LOG, e, path);
        }
        return databases;
    }

    public String getCurrentDatabase() {
        String database = "";
        try {
            ResultSet rs = getResultSet("SELECT database()");
            rs.next();
            database = rs.getString(1);
        } catch (SQLException e) {
            String path = "manager.database.DatabaseManager.getCurrentDatabase()";
            Log.saveErrorLog(LOG, e, path);
        }
        return database;
    }

    public String getCurrentUser() {
        String currentUser = "";
        try {
            ResultSet rs = getResultSet("SELECT current_user()");
            rs.next();
            currentUser = rs.getString(1);
        } catch (SQLException e) {
            String path = "manager.database.DatabaseManager.getCurrentUser()";
            Log.saveErrorLog(LOG, e, path);
        }
        return currentUser;
    }
}