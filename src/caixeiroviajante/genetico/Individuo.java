package caixeiroviajante.genetico;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author gabrielamaral
 */
public class Individuo {

    private final ArrayList<Cidade> rota;
    private double fitness;
    private double distancia;

    public Individuo(Caminho caminho) {
        this.rota = new ArrayList<>();
        for (int i = 0; i < caminho.getNumeroDeCidades(); i++) {
            rota.add(null);
        }
        this.fitness = 0;
        this.distancia = 0;
    }

    public void gerarIndividuo(Caminho caminho) {
        for (int i = 0; i < caminho.getNumeroDeCidades(); i++) {
            setCidade(i, caminho.getCidade(i));
        }
        Collections.shuffle(rota);
    }

    public Cidade getCidade(int indice) {
        return rota.get(indice);
    }

    public void setCidade(int indice, Cidade cidade) {
        rota.set(indice, cidade);
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
                if ((i + 1) < tamanhoDaRota()) {
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
        return rota.size();
    }

    public boolean contemCidade(Cidade cidade) {
        return rota.contains(cidade);
    }

    @Override
    public String toString() {
        String caminho = "[";
        for (int i = 0; i < tamanhoDaRota(); i++) {
            caminho += getCidade(i) + " ";
        }
        caminho += "]";
        return caminho;
    }

}