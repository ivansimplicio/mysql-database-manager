package manager.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {

    public static String Read(String caminho) throws Exception {
        BufferedReader lerArq;
        try {
            String conteudo = "";
            lerArq = new BufferedReader(new FileReader(caminho));
            try {
                String linha = lerArq.readLine();
                while (linha != null) {
                    conteudo += linha + "\n";
                    linha = lerArq.readLine();
                }
                lerArq.close();
                return conteudo;
            } catch (IOException e) {
                throw new Exception("Não foi possível ler do arquivo!");
            }
        } catch (FileNotFoundException e) {
            throw new Exception("Arquivo não encontrado!");    
        }
    }

    public static void Write(String caminho, String texto){
        PrintWriter gravarArq;
        try {
            gravarArq = new PrintWriter(new FileWriter(caminho));
            gravarArq.println(texto);
            gravarArq.close();
        } catch (IOException e) {
            //adicionar no arquivo de log
            throw new RuntimeException("Erro na criação do arquivo!");
        }
    }
}