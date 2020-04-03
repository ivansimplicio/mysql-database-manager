package manager.enums;

public enum QueryType {
    INSERT_QUERY("Inserir comando"),
    CONSULT_PROCEDURES("Procedures"),
    CONSULT_TABLES("Tabelas");
    
    private final String value;
    
    private QueryType(String value){
        this.value = value;
    }
    
    public String getValue(){
        return this.value;
    }
}