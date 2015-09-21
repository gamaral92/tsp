package caixeiroviajante.genetico;

import java.util.Random;

/**
 *
 * @author gabrielamaral
 */
public class Evolucao {

    private final double taxaMutacao;
    private final int tamanhoTorneio;
    private final boolean elitismo;
    private final Caminho caminho;

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
            novaPopulacao.salvarIndividuo(0, populacao.getIndividuoMaisApto());
            elitismoCompensador = 1;
        }

        for (int i = elitismoCompensador; i < novaPopulacao.tamanhoPopulacao(); i++) {
            Individuo pai1 = torneio(populacao);
            Individuo pai2 = torneio(populacao);
            
            Individuo filho = crossOver(pai1, pai2);

            novaPopulacao.salvarIndividuo(i, filho);
        }

        for (int i = elitismoCompensador; i < populacao.tamanhoPopulacao(); i++) {
            mutacaoTroca(novaPopulacao.getIndividuo(i));
            //mutacaoScramble(novaPopulacao.getIndividuo(i));
            //mutacaoInsercao(novaPopulacao.getIndividuo(i));
        }

        return novaPopulacao;
    }

    private Individuo torneio(Populacao populacao) {
        Populacao torneio = new Populacao(tamanhoTorneio, false, caminho);
        for (int i = 0; i < tamanhoTorneio; i++) {
            int idAleatorio = (int) (Math.random() * populacao.tamanhoPopulacao());
            torneio.salvarIndividuo(i, populacao.getIndividuo(idAleatorio));
        }
        Individuo maisApto = torneio.getIndividuoMaisApto();
        return maisApto;
    }

    private Individuo crossOver(Individuo pai1, Individuo pai2) {
        Individuo filho = new Individuo(caminho);

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

    private void mutacaoTroca(Individuo individuo) {
        if (Math.random() < taxaMutacao) {
            int indiceOrigem = (int) (individuo.tamanhoDaRota() * Math.random());
            int indiceDestino = (int) (individuo.tamanhoDaRota() * Math.random());

            Cidade cidade1 = individuo.getCidade(indiceOrigem);
            Cidade cidade2 = individuo.getCidade(indiceDestino);

            individuo.setCidade(indiceOrigem, cidade2);
            individuo.setCidade(indiceDestino, cidade1);
        }
    }

    private void mutacaoInsercao(Individuo individuo) {
        if (Math.random() < taxaMutacao) {
            int indiceOrigem = (int) (individuo.tamanhoDaRota() * Math.random());
            int indiceDestino = (int) (individuo.tamanhoDaRota() * Math.random());
            if (indiceOrigem > indiceDestino) {
                int aux = indiceOrigem;
                indiceOrigem = indiceDestino;
                indiceDestino = aux;
            }
            Cidade cidade = individuo.getCidade(indiceOrigem);
            for (int i = indiceOrigem; i < indiceDestino; i++) {
                individuo.setCidade(i, individuo.getCidade(i + 1));
            }
            individuo.setCidade(indiceDestino, cidade);
        }
    }

    private void mutacaoScramble(Individuo individuo) {
        if (Math.random() < taxaMutacao) {
            int indiceOrigem = (int) (individuo.tamanhoDaRota() * Math.random());
            int indiceDestino = (int) (individuo.tamanhoDaRota() * Math.random());
            if (indiceOrigem > indiceDestino) {
                int aux = indiceOrigem;
                indiceOrigem = indiceDestino;
                indiceDestino = aux;
            }
            Random random = new Random();
            for (int i = indiceOrigem; i < indiceDestino; i++) {
                int j = i + (random.nextInt(indiceDestino) + indiceOrigem) % (indiceDestino - i);
                Cidade cidade = individuo.getCidade(i);
                individuo.setCidade(i, individuo.getCidade(j));
                individuo.setCidade(j, cidade);
            }
        }
    }

}
