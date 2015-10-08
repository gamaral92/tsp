package caixeiroviajante.genetic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author a11030
 */
public class Arquivo {

    private final File arquivo;
    private FileWriter fw;
    private BufferedWriter bw;

    public Arquivo(String nome) {
        nome = "r/" + nome;
        arquivo = new File(nome);
        try {
            fw = new FileWriter(arquivo);
            bw = new BufferedWriter(fw);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void escrever(String conteudo) {
        try {
            bw.write(conteudo);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void quebraLinha() {
        try {
            bw.newLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     public void salvar() {
        try {
            bw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void fecharRecursos() {
        try {
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
