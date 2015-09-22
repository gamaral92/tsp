package caixeiroviajante.genetico;

import java.util.Arrays;

/**
 *
 * @author gabrielamaral
 */
public class Main {

    public static void main(String[] args) {
        Caminho caminho = new Caminho();
        //caminho.lerArquivo("burma14.tsp"); //3323
        //caminho.lerArquivo("ulysses16.tsp"); //6859
        //caminho.lerArquivo("ulysses22.tsp"); //7013
        caminho.lerArquivo("gr96.tsp"); //55209
        //caminho.lerArquivo("gr137.tsp"); //69853

        Evolucao e = new Evolucao(0.2, 25, true, caminho);
        //[tamanhoPop, taxaMutacao, tamanhoTorneio, geracoes]
        Populacao p = new Populacao(caminho.getNumeroDeCidades() * 20, true, caminho);
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
//        double taxaMutacao = 0.001;
//        while (taxaMutacao <= 0.05) {
//            int tamanhoTorneio = 1;
//            while (tamanhoTorneio <= 30) {
//                Evolucao evolucao = new Evolucao(taxaMutacao, tamanhoTorneio, true, caminho);
//                int tamanhoPop = caminho.getNumeroDeCidades();
//                while (tamanhoPop <= caminho.getNumeroDeCidades() * 20) {
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
//                    tamanhoPop *= 2;
//                }
//                tamanhoTorneio += 5;
//            }
//            taxaMutacao = taxaMutacao + 0.001;
//        }
//
//        System.out.println("best = " + bestCost);
//        System.out.println(Arrays.toString(parametros));

    }
}
