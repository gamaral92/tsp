package caixeiroviajante.genetico;

import java.util.Arrays;

/**
 *
 * @author gabrielamaral
 */
public class Main {

    public static void main(String[] args) {
        Caminho caminho = new Caminho();
        caminho.lerArquivo("burma14.tsp");
        //caminho.lerArquivo("ulysses16.tsp");
        //caminho.lerArquivo("ulysses22.tsp");
        //caminho.lerArquivo("gr96.tsp");
        //caminho.lerArquivo("gr137.tsp");

        Evolucao e = new Evolucao(0.01, 5, true, caminho);
        //[tamanhoPop, taxaMutacao, tamanhoTorneio, geracoes]
        Populacao p = new Populacao(100, true, caminho);
        System.out.println(p.getIndividuoMaisApto());
        System.out.println("Distancia inicial = " + p.getIndividuoMaisApto().getDistancia());
        for (int i = 0; i < 1000; i++) {
            p = e.desenvolverPopulacao(p);
        }
        System.out.println("Solucao:");
        System.out.println(p.getIndividuoMaisApto());
        System.out.println("Distancia final = " + p.getIndividuoMaisApto().getDistancia());

//        double bestCost = Integer.MAX_VALUE;
//        
//        double[] parametros = new double[4];
//
//        double taxaMutacao = 0.005;
//        while (taxaMutacao <= 0.05) {
//            int tamanhoTorneio = 2;
//            while (tamanhoTorneio <= 5) {
//                Evolucao evolucao = new Evolucao(taxaMutacao, tamanhoTorneio, true, caminho);
//                int tamanhoPop = 50;
//                while (tamanhoPop <= 200) {
//                    int geracoes = 100;
//                    while (geracoes <= 1000) {
//                        Populacao populacao = new Populacao(tamanhoPop, true, caminho);
//                        //System.out.println(populacao.getIndividuoMaisApto());
//                        //System.out.println("Distancia inicial = " + populacao.getIndividuoMaisApto().getDistancia());
//                        for (int i = 0; i < geracoes; i++) {
//                            populacao = evolucao.desenvolverPopulacao(populacao);
//                        }
//                        //System.out.println("tamanhoPop = " + tamanhoPop);
//                        //System.out.println("taxaMutacao = " + taxaMutacao);
//                        //System.out.println("tamanhoTorneio = " + tamanhoTorneio);
//                        //System.out.println("geracoes = " + geracoes);
//                        //System.out.println("Distancia final = " + populacao.getIndividuoMaisApto().getDistancia());
//                        if (populacao.getIndividuoMaisApto().getDistancia() < bestCost) {
//                            bestCost = populacao.getIndividuoMaisApto().getDistancia();
//                            parametros[0] = tamanhoPop;
//                            parametros[1] = taxaMutacao;
//                            parametros[2] = tamanhoTorneio;
//                            parametros[3] = geracoes;
//                        }
//                        //System.out.println("Solucao:");
//                        //System.out.println(populacao.getIndividuoMaisApto());
//                        //System.out.println("Fim");
//                        //System.out.println("-------------------------------------------");
//                        geracoes *= 10;
//                    }
//                    tamanhoPop += 50;
//                }
//                tamanhoTorneio++;
//            }
//            taxaMutacao = taxaMutacao + 0.005;
//        }
//
//        System.out.println("best = " + bestCost);
//        System.out.println(Arrays.toString(parametros));

    }
}
