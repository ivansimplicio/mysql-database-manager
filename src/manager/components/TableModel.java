package manager.components;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import manager.util.Log;
import org.apache.log4j.Logger;

public class TableModel {
    
    private static final Logger LOG = Logger.getLogger(TableModel.class);
    
    public static void load(JTable table, ResultSet rs){
        try {
            ResultSetMetaData rsmt = rs.getMetaData();
            int columnCount = rsmt.getColumnCount();
            Object[] columnNames = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = rsmt.getColumnName(i).toUpperCase();
            }
            MyTableModel model = new MyTableModel(columnNames, 0);
            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rows[i - 1] = rs.getObject(i);
                }
                model.addRow(rows);
            }
            table.setModel(model);
        } catch (SQLException e) {
            String path = "manager.components.TableModel.load(JTable, ResultSet)";
            Log.saveErrorLog(LOG, e, path);
        }
    }
}