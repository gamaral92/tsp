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
public class Evolucao {

    private double taxaMutacao;
    private int tamanhoTorneio;
    private boolean elitismo;
    private Caminho caminho;

    public Evolucao(double taxaMutacao, int tamanhoTorneio, boolean elitismo, Caminho caminho) {
        this.taxaMutacao = taxaMutacao;
        this.tamanhoTorneio = tamanhoTorneio;
        this.elitismo = elitismo;
        this.caminho = caminho;
    }

    public Populacao desenvolverPopulacao(Populacao populacao) {
        Populacao novaPopulacao = new Populacao(populacao.tamanhoPopulacao(), false, caminho);

        int elitismoCompensador = 0;
        if (elitismo) {
            novaPopulacao.salvarRota(0, populacao.getApto());
            elitismoCompensador = 1;
        }

        for (int i = elitismoCompensador; i < novaPopulacao.tamanhoPopulacao(); i++) {
            Rota pai1 = torneio(populacao);
            Rota pai2 = torneio(populacao);

            Rota filho = crossOver(pai1, pai2);

            novaPopulacao.salvarRota(i, filho);
        }

        for (int i = elitismoCompensador; i < populacao.tamanhoPopulacao(); i++) {
            mutacao(novaPopulacao.getRota(i));
        }

        return novaPopulacao;
    }

    private Rota torneio(Populacao populacao) {
        Populacao torneio = new Populacao(tamanhoTorneio, false, caminho);
        for (int i = 0; i < tamanhoTorneio; i++) {
            int idAleatorio = (int) (Math.random() * populacao.tamanhoPopulacao());
            torneio.salvarRota(i, populacao.getRota(idAleatorio));
        }
        Rota apto = torneio.getApto();
        return apto;
    }

    private Rota crossOver(Rota pai1, Rota pai2) {
        Rota filho = new Rota(caminho);

        int posicaoInicial = (int) (Math.random() * pai1.tamanhoDaRota());
        int posicaoFinal = (int) (Math.random() * pai1.tamanhoDaRota());

        for (int i = 0; i < filho.tamanhoDaRota(); i++) {
            if (posicaoInicial < posicaoFinal && i > posicaoInicial && i < posicaoFinal) {
                filho.setCidade(i, pai1.getCidade(i));
            } else if (posicaoInicial > posicaoFinal) {
                if (!(i < posicaoInicial && i > posicaoFinal)) {
                    filho.setCidade(i, pai1.getCidade(i));
                }
            }
        }

        for (int i = 0; i < pai2.tamanhoDaRota(); i++) {
            if (!filho.contemCidade(pai2.getCidade(i))) {
                for (int j = 0; j < filho.tamanhoDaRota(); j++) {
                    if (filho.getCidade(j) == null) {
                        filho.setCidade(j, pai2.getCidade(i));
                        break;
                    }
                }
            }
        }

        return filho;
    }

    private void mutacao(Rota rota) {
        for (int posicaoRota = 0; posicaoRota < rota.tamanhoDaRota(); posicaoRota++) {
            if (Math.random() < taxaMutacao) {
                int posicaoRota2 = (int) (rota.tamanhoDaRota() * Math.random());

                Cidade cidade = rota.getCidade(posicaoRota);
                Cidade cidade2 = rota.getCidade(posicaoRota2);

                rota.setCidade(posicaoRota, cidade2);
                rota.setCidade(posicaoRota2, cidade);
            }
        }
    }
}
