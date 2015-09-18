package caixeiroviajante.genetico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author gabrielamaral
 */
public class Caminho {

    private Cidade[] cidades;

    public void adicionarCidade(Cidade cidade, int indice) {
        cidades[indice] = cidade;
    }

    public Cidade getCidade(int indice) {
        return cidades[indice];
    }

    public int getNumeroDeCidades() {
        return cidades.length;
    }
    
    public boolean lerArquivo(String nomeArquivo){
        try {
            FileReader fileReader = new FileReader(new File(nomeArquivo));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            if (bufferedReader.ready()) {
                String linha = bufferedReader.readLine();
                String[] parametros = linha.split(" ");
                int quantidadeDeCidades = Integer.parseInt(parametros[0]);
                cidades = new Cidade[quantidadeDeCidades];
            }

            int indice = 0;
            while (bufferedReader.ready()) {
                String linha = bufferedReader.readLine();
                String[] parametros = linha.split(" ");
                Cidade cidade = new Cidade(Integer.parseInt(parametros[1]), Double.parseDouble(parametros[2]), Double.parseDouble(parametros[3]));
                adicionarCidade(cidade, indice);
                indice++;
            }

            bufferedReader.close();
            fileReader.close();
            return true;
        } catch (IOException ex) {
            System.out.println("Arquivo " + nomeArquivo + " não encontrado.");
            return false;
        }
    }
}
