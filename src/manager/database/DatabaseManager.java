package manager.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

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

    public void fecharConexao() {
        this.con.fecharConexao();
        manager = null;
    }
    public boolean inserirComando(String sql) {
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public ResultSet getResultSet(String comando) throws Exception {
        ResultSet rs = null;
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(comando);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            throw new Exception("COMANDO INCORRETO!");
        }
        return rs;
    }

    public List<String> getTablesNames() throws RuntimeException {
        String sql = "SHOW TABLES";
        List<String> tabelas = new ArrayList<>();
        try {
            ResultSet rs = this.getResultSet(sql);
            while (rs.next()) {
                tabelas.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw new RuntimeException("NENHUM BANCO DE DADOS ABERTO!");
        }
        if (tabelas.isEmpty()) {
            throw new RuntimeException("O BANCO DE DADOS NÃO POSSUI TABELAS!");
        }
        return tabelas;
    }

    public List<String> getExistingProcedures(String databaseUsing) {
        String sql = String.format("SHOW PROCEDURE STATUS WHERE db = '%s'", databaseUsing);
        List<String> procedures = new ArrayList<>();
        try {
            ResultSet rs = this.getResultSet(sql);
            while (rs.next()) {
                procedures.add(rs.getString("Name"));
            }
        } catch (Exception e) {
            //adicionar no arquivo de log
            throw new RuntimeException("ERRO! Path: Gerenciador.getExistingProcedures()");
        }
        return procedures;
    }

    public List<String> getDatabasesNames() {
        String sql = "SHOW DATABASES";
        List<String> schemas = new ArrayList<>();
        try {
            ResultSet rs = this.getResultSet(sql);
            while (rs.next()) {
                schemas.add(rs.getString(1));
            }
        } catch (Exception e) {
            //adicionar no arquivo de log
            throw new RuntimeException("ERRO! Path: Gerenciador.getDatabasesNames()");
        }
        return schemas;
    }

    public String getCurrentDatabase() {
        String database = "";
        try {
            ResultSet rs = getResultSet("SELECT database()");
            rs.next();
            database = rs.getString(1);
        } catch (Exception e) {
            //adicionar no arquivo de log
            throw new RuntimeException("ERRO! Path: Gerenciador.getCurrentDatabase()");
        }
        return database;
    }

    public String getCurrentUser() {
        String currentUser = "";
        try {
            ResultSet rs = getResultSet("SELECT current_user()");
            rs.next();
            currentUser = rs.getString(1);
        } catch (Exception e) {
            //adicionar no arquivo de log
            throw new RuntimeException("ERRO! Path: Gerenciador.getCurrentUser()");
        }
        return currentUser;
    }
}