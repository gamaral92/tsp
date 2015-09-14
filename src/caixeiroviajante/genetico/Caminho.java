package caixeiroviajante.genetico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author gabrielamaral
 */
public class Caminho {

    private ArrayList<Cidade> cidades;

    public void adicionarCidade(Cidade cidade) {
        cidades.add(cidade);
    }

    public Cidade getCidade(int indice) {
        return cidades.get(indice);
    }

    public int getNumeroDeCidades() {
        return cidades.size();
    }
    
    public boolean lerArquivo(String nomeArquivo){
        try {
            FileReader fileReader = new FileReader(new File(nomeArquivo));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            if (bufferedReader.ready()) {
                String linha = bufferedReader.readLine();
                String[] parametros = linha.split(" ");
                int quantidadeDeCidades = Integer.parseInt(parametros[0]);
                cidades = new ArrayList<>(quantidadeDeCidades);
            }

            while (bufferedReader.ready()) {
                String linha = bufferedReader.readLine();
                String[] parametros = linha.split(" ");
                Cidade cidade = new Cidade(Integer.parseInt(parametros[1]), Double.parseDouble(parametros[2]), Double.parseDouble(parametros[3]));
                adicionarCidade(cidade);
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
