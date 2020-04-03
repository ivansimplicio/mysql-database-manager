package manager.components;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel{
    
    /**
     * Construtor padrão da classe.
     * @param columnNames Nomes das colunas que serão adicionadas na jTable.
     * @param rowNumber Valor que indica qual a linha em que o jTable deve começar a preencher.
     */
    public MyTableModel(Object[] columnNames, int rowNumber){
        super(columnNames, rowNumber);
    }
    
    /**
     * Método sobrescrito que retornará false em todos os casos (nenhuma linha/coluna editável).
     * @param row Linha da jTable.
     * @param column Coluna da jTable.
     * @return False em todas as linhas e colunas.
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}