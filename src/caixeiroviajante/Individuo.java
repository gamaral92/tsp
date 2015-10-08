package caixeiroviajante;

import java.util.Random;

/**
 *
 * @author gabrielamaral
 */
public class Individuo {

    private final Cidade[] rota;
    private double fitness;
    private double distancia;

    public Individuo(int tamanho) {
        this.rota = new Cidade[tamanho];
        this.fitness = 0;
        this.distancia = 0;
    }
    
    public Individuo(Cidade[] rota) {
        this.rota = new Cidade[rota.length];
        clonarRota(rota);
        this.fitness = 0;
        this.distancia = 0;
    }

    public Cidade[] getRota() {
        return rota;
    }
    
    public void gerarIndividuo(Caminho caminho) {
        for (int i = 0; i < caminho.getNumeroDeCidades(); i++) {
            setCidade(i, caminho.getCidade(i));
        }
        shuffle(rota);
    }

    private void shuffle(Cidade[] cidades) {
        Random random = new Random();
        for (int i = 0; i < cidades.length * 0.2; i++) {
            int j = i + random.nextInt(cidades.length) % (cidades.length - i);
            Cidade cidade = cidades[i];
            cidades[i] = cidades[j];
            cidades[j] = cidade;
        }
    }

    public Cidade getCidade(int indice) {
        return rota[indice];
    }

    public void setCidade(int indice, Cidade cidade) {
        rota[indice] = cidade;
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
                //distanciaDaRota += origem.distanciaEUCAte(destino);
                distanciaDaRota += origem.distanciaGEOAte(destino);
            }
            this.distancia = distanciaDaRota;
        }
        return this.distancia;
    }

    public int tamanhoDaRota() {
        return rota.length;
    }

    public boolean contemCidade(Cidade cidade) {
        for (Cidade c : rota) {
            if (c != null && c.getId() == cidade.getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String caminho = "[";
        for (int i = 0; i < tamanhoDaRota(); i++) {
            caminho += getCidade(i);
            if (i + 1 < tamanhoDaRota()) {
                caminho += "\t";
            }
        }
        caminho += "]";
        return caminho;
    }

    private void clonarRota(Cidade[] rota) {
        for (int i = 0; i < rota.length; i++) {
            this.rota[i] = new Cidade(rota[i].getId(), rota[i].getX(), rota[i].getY());
        }
    }

}
