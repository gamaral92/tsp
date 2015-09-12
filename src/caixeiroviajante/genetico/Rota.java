/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixeiroviajante.genetico;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author gabrielamaral
 */
public class Rota {

    private ArrayList<Cidade> rotas;
    private double fitness;
    private double distancia;

    public Rota(Caminho caminho) {
        this.rotas = new ArrayList<>();
        for (int i = 0; i < caminho.getNumeroDeCidades(); i++) {
            rotas.add(null);
        }
    }
    

    public Rota(ArrayList<Cidade> rotas) {
        this.rotas = rotas;
        this.fitness = 0;
        this.distancia = 0;
    }

    public void gerarIndividuo(Caminho caminho) {
        for (int i = 0; i < caminho.getNumeroDeCidades(); i++) {
            setCidade(i, caminho.getCidade(i));
        }
        Collections.shuffle(rotas);
    }

    public Cidade getCidade(int indice) {
        return rotas.get(indice);
    }

    public void setCidade(int indice, Cidade cidade) {
        rotas.set(indice, cidade);
        this.fitness = 0;
        this.distancia = 0;
    }

    public double getFitness() {
        if (this.fitness == 0) {
            this.fitness = 1 / getDistancia();
        }
        return this.fitness;
    }

    public double getDistancia() {
        if (this.distancia == 0) {
            int distanciaDaRota = 0;
            for (int i = 0; i < tamanhoDaRota(); i++) {
                Cidade origem = getCidade(i);
                Cidade destino;
                if (i + 1 < tamanhoDaRota()) {
                    destino = getCidade(i + 1);
                } else {
                    destino = getCidade(0);
                }
                distanciaDaRota += origem.distanciaAte(destino);
            }
            this.distancia = distanciaDaRota;
        }
        return this.distancia;
    }

    public int tamanhoDaRota() {
        return rotas.size();
    }

    public boolean contemCidade(Cidade cidade) {
        return rotas.contains(cidade);
    }

    @Override
    public String toString() {
        String geneString = "[";
        for (int i = 0; i < tamanhoDaRota(); i++) {
            geneString += getCidade(i) + " ";
        }
            geneString += "]";
        return geneString;
    }

}
