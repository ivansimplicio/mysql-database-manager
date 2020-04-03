package manager.database;

import java.sql.DriverManager;
import java.sql.SQLException;
import manager.util.Log;
import org.apache.log4j.Logger;

public class Connection {
    
    private static final Logger LOG = Logger.getLogger(Connection.class);

    private static Connection con;
    private java.sql.Connection connection = null;

    private Connection(String host, String database, String username, String password) throws SQLException {
        connection = getConnection(host, database, username, password);
    }

    public static Connection getInstance(String host, String database, String username, String password) throws SQLException {
        if (con == null) {
            con = new Connection(host, database, username, password);
        }
        return con;
    }

    private java.sql.Connection getConnection(String host, String database, String username, String password) throws SQLException {
        try {
            String url = String.format("jdbc:mysql://%s/%s", host, database);
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new SQLException("ERRO AO CONECTAR!");
        }
    }
    
    public java.sql.Connection getConnection(){
        return this.connection;
    }

    public void close() {
        try {
            connection.close();
            con = null;
        } catch (SQLException e) {
            String path = "manager.database.Connection.close()";
            Log.saveErrorLog(LOG, e, path);
        }
    }
}