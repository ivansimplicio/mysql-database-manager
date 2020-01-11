package manager.enums;

import javax.swing.JOptionPane;

public enum SystemMessages {
    
    SYSTEM_INFO("Sobre o Sistema",
            "<html><div align=\"center\">Este gerenciador foi desenvolvido com  o intuito de facilitar operações"
            + "simples sobre um Schema, focando  em  consultas  rápidas, essenciais"
            + "na etapa  de desenvolvimento e testes de softwares.<br><br>"
            + "<b>Desenvolvido por:</b><br>Ivan Simplício<br><br>"
            + "<b>Feedback:</b><br>ivansimplicio@outlook.com</div> </html>"),
    
    QUERY_ERROR("Informações sobre Erros em Consultas",
            "<html><div align=\"left\">>>> Esta aba é exclusiva para consulta de dados em"
            + "tabelas. Para tal, é necessario o uso do comando SELECT"
            + "(somente ele). Portanto, não é possível utilizar comandos"
            + "como UPDATE, DELETE, DROP, INSERT, etc. nesta área.<br><br>"
            + ">>> Em caso de erro, verifique sua instrução, e tente"
            + "novamente.<br><br>"
            + ">>> Caso esteja tentando chamar algum procedimento e"
            + "tenha ocorrido um erro, significa que o procedimento"
            + "selecionado não foi criado para consulta de dados, mas"
            + "para outros fins. Por favor, selecione outro procedimento.</div> </html>"),
    
    LOGIN_ERROR("Sobre erro no login",
            "<html><div align=\"left\"><br>Verifique se:<br><br>"
            + ">>> Todos os campos foram completados corretamente.<br>"
            + ">>> O mysql-connector-java foi excluído do sistema.<br>"
            + ">>> O MySQL foi instalado corretamente.</div> </html>");
  
    private String title;
    private String message;

    private SystemMessages(String title, String message){
        this.title = title;
        this.message = message;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public static int infoSelectMessage(String message){
        Object[] options = {"OK", "MAIS INFORMAÇÕES"};
        return JOptionPane.showOptionDialog(null, message, "AVISO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null,options, options[0]);
    }
}