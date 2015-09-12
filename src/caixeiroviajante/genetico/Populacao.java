/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixeiroviajante.genetico;

import java.util.ArrayList;

/**
 *
 * @author gabrielamaral
 */
public class Populacao {

    private Rota[] rotas;

    public Populacao(int tamanhoPopulacao, boolean iniciar, Caminho caminho) {
        rotas = new Rota[tamanhoPopulacao];
        if (iniciar) {
            for (int i = 0; i < tamanhoPopulacao(); i++) {
                Rota novaRota = new Rota(caminho);
                novaRota.gerarIndividuo(caminho);
                salvarRota(i, novaRota);
            }
        }
    }

    public void salvarRota(int indice, Rota rota) {
        rotas[indice] = rota;
    }

    public Rota getRota(int indice) {
        return rotas[indice];
    }

    public Rota getApto() {
        Rota apto = rotas[0];
        for (int i = 0; i < tamanhoPopulacao(); i++) {
            if (apto.getFitness() <= getRota(i).getFitness()) {
                apto = getRota(i);
            }
        }
        return apto;
    }

    public int tamanhoPopulacao() {
        return rotas.length;
    }

}
