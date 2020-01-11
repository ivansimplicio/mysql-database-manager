package manager.components;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel{
    
    /**
     * Construtor padrão da classe.
     * @param nomesColunas Nomes das colunas que serão adicionadas na jTable.
     * @param i Valor que indica qual a linha em que o jTable deve começar a preencher.
     */
    public MyTableModel(Object[] nomesColunas, int i){
        super(nomesColunas, i);
    }
    
    /**
     * Método sobrescrito que retornará false em todos os casos (nenhuma linha/coluna editável).
     * @param linha Linha da jTable.
     * @param coluna Coluna da jTable.
     * @return False em todas as linhas e colunas.
     */
    @Override
    public boolean isCellEditable(int linha, int coluna) {
        return false;
    }
}