package manager.components;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;

public class TableModel {
    
    public static void load(JTable table, ResultSet rs){
        try {
            ResultSetMetaData rsmt = rs.getMetaData();
            int numeroColunas = rsmt.getColumnCount();
            Object[] nomeColunas = new Object[numeroColunas];
            for (int i = 1; i <= numeroColunas; i++) {
                nomeColunas[i - 1] = rsmt.getColumnName(i).toUpperCase();
            }
            MyTableModel modelo = new MyTableModel(nomeColunas, 0);
            while (rs.next()) {
                Object[] linhas = new Object[numeroColunas];
                for (int i = 1; i <= numeroColunas; i++) {
                    linhas[i - 1] = rs.getObject(i);
                }
                modelo.addRow(linhas);
            }
            table.setModel(modelo);
        } catch (SQLException e) {
            //adicionar no arquivo de log
            throw new RuntimeException("ERRO! Path: manager.database.TableModel.load(JTable, ResultSet)");
        }
    }
}