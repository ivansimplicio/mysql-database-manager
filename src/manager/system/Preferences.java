package manager.system;

public class Preferences {
    
    private String host;
    private String database;
    private String username;
    private String password;
    
    private boolean clearTextArea;
    private boolean multiQueries;
    private String standardCommand;
    
    public Preferences(){
        this.host = "127.0.0.1:3306";
        this.database = "";
        this.username = "root";
        this.password = "";
        this.clearTextArea = true;
        this.multiQueries = true;
        this.standardCommand = "";
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isClearTextArea() {
        return clearTextArea;
    }

    public void setClearTextArea(boolean clearTextArea) {
        this.clearTextArea = clearTextArea;
    }

    public boolean isMultiQueries() {
        return multiQueries;
    }

    public void setMultiQueries(boolean multiQueries) {
        this.multiQueries = multiQueries;
    }

    public String getStandardCommand() {
        return standardCommand;
    }

    public void setStandardCommand(String standardCommand) {
        this.standardCommand = standardCommand;
    }
}