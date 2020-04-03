package manager.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class File {

    public static String Read(String path) throws IOException, FileNotFoundException {
        BufferedReader readFile;
        try {
            String content = "";
            readFile = new BufferedReader(new FileReader(path));
            try {
                String row = readFile.readLine();
                while (row != null) {
                    content += row + "\n";
                    row = readFile.readLine();
                }
                readFile.close();
                return content;
            } catch (IOException e) {
                throw new IOException("Não foi possível ler do arquivo!");
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo não encontrado!");    
        }
    }

    public static void Write(String path, String content) throws IOException{
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileWriter(path));
            pw.print(content);
            pw.close();
        } catch (IOException e) {
            throw new IOException("Não foi possível criar o arquivo.");
        }
    }
}