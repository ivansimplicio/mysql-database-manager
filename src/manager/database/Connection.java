package manager.database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private static Connection conexao;
    private java.sql.Connection connection = null;

    private Connection(String IP, String BD, String login, String senha) throws Exception {
        connection = getConnection(IP, BD, login, senha);
    }

    public static Connection getInstance(String IP, String bd, String login, String senha) throws Exception {
        if (conexao == null) {
            conexao = new Connection(IP, bd, login, senha);
        }
        return conexao;
    }

    private java.sql.Connection getConnection(String IP, String BD, String login, String senha) throws Exception {
        try {
            String local = String.format("jdbc:mysql://%s/%s", IP, BD);
            return DriverManager.getConnection(local, login, senha);
        } catch (SQLException e) {
            throw new Exception("ERRO AO CONECTAR!");
        }
    }
    
    public java.sql.Connection getConnection(){
        return this.connection;
    }

    public void fecharConexao() {
        try {
            connection.close();
            conexao = null;
        } catch (SQLException e) {
            //adicionar no arquivo de log
            throw new RuntimeException("ERRO! Path: Conexao.fecharConexao()");
        }
    }
}