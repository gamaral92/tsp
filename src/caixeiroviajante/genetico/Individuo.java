package caixeiroviajante.genetico;

import java.util.Random;

/**
 *
 * @author gabrielamaral
 */
public class Individuo {

    private final Cidade[] rota;
    private double fitness;
    private double distancia;

    public Individuo(Caminho caminho) {
        this.rota = new Cidade[caminho.getNumeroDeCidades()];
        this.fitness = 0;
        this.distancia = 0;
    }

    public void gerarIndividuo(Caminho caminho) {
        for (int i = 0; i < caminho.getNumeroDeCidades(); i++) {
            setCidade(i, caminho.getCidade(i));
        }
        shuffle(rota);
    }

    private void shuffle(Cidade[] cidades) {
        Random random = new Random();
        for (int i = 0; i < cidades.length; i++) {
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

}
