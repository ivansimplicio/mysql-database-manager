package manager.system;

import manager.util.Arquivo;

public class Configuracoes {
    
    private static Configuracoes configuracoesInstance;
    
    private final String CONFIG_PADRAO = "marked¬marked¬NENHUM COMANDO FOI INSERIDO¬";
    private final String LOCAL_FILE = "settings.config";
    private boolean checkBox1Marked;
    private boolean checkBox2Marked;
    private String comandoPadrao;
    
    private Configuracoes(){
        lerConfiguracoes();
    }
    
    public static Configuracoes getInstance(){
        if(configuracoesInstance == null){
            configuracoesInstance = new Configuracoes();
        }
        return configuracoesInstance;
    }
    
    private void lerConfiguracoes(){
        String configuracoes = null;
        try{
            configuracoes = Arquivo.Read(LOCAL_FILE);
        }catch(Exception e){
            configuracoes = CONFIG_PADRAO;
            Arquivo.Write(LOCAL_FILE, configuracoes);
        }
        preencheConfiguracoes(configuracoes);
    }
    
    private void preencheConfiguracoes(String configuracoes){
        String[] configs = configuracoes.split("¬");
        this.checkBox1Marked = configs[0].equals("marked");
        this.checkBox2Marked = configs[1].equals("marked");
        this.comandoPadrao = configs[2];
    }
    
    public boolean checkBox1Marked(){
        return checkBox1Marked;
    }
    
    public boolean checkBox2Marked(){
        return checkBox2Marked;
    }
    
    public String getComandoPadrao(){
        return comandoPadrao;
    }
    
    public void salvarConfigs(boolean checkBox1Marked, boolean checkBox2Marked, String comandoPadrao){
        String configuracoes = "";
        configuracoes += checkBox1Marked ? "marked¬" : "unmarked¬";
        configuracoes += checkBox2Marked ? "marked¬" : "unmarked¬";
        if(comandoPadrao.trim().isEmpty()){
            configuracoes += getComandoPadrao()+"¬";
        }else{
            configuracoes += comandoPadrao+"¬";
        }
        Arquivo.Write(LOCAL_FILE, configuracoes);
        preencheConfiguracoes(configuracoes);
    }
}