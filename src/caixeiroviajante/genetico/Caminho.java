/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    private ArrayList<Cidade> caminho;

    public void adicionarCidade(Cidade cidade) {
        caminho.add(cidade);
    }

    public Cidade getCidade(int indice) {
        return caminho.get(indice);
    }

    public int getNumeroDeCidades() {
        return caminho.size();
    }
    
    public boolean lerArquivo(String nomeArquivo){
        try {
            FileReader fileReader = new FileReader(new File(nomeArquivo));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            if (bufferedReader.ready()) {
                String linha = bufferedReader.readLine();
                String[] parametros = linha.split(" ");
                int quantidadeDeCidades = Integer.parseInt(parametros[0]);
                caminho = new ArrayList<>(quantidadeDeCidades);
            }


            while (bufferedReader.ready()) {
                String linha = bufferedReader.readLine();
                String[] parametros = linha.split(" ");
                Cidade cidade = new Cidade(Integer.parseInt(parametros[1]), 
                        Double.parseDouble(parametros[2]), Double.parseDouble(parametros[3]));
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
