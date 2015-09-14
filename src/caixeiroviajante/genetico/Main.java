package caixeiroviajante.genetico;

/**
 *
 * @author gabrielamaral
 */
public class Main {

    public static void main(String[] args) {
        Caminho caminho = new Caminho();
        caminho.lerArquivo("gr137.tsp");

        Evolucao e = new Evolucao(0.01, 5, true, caminho);
        Populacao p = new Populacao(50, true, caminho);
        System.out.println(p.getIndividuoApto());
        System.out.println("Distancia inicial = " + p.getIndividuoApto().getDistancia());
        for (int i = 0; i < 100; i++) {
            p = e.desenvolverPopulacao(p);
        }
        System.out.println("Solucao:");
        System.out.println(p.getIndividuoApto());
        System.out.println("Distancia final = " + p.getIndividuoApto().getDistancia());

//        double bestCost = Integer.MAX_VALUE;
//
//        double taxaMutacao = 0.01;
//        while (taxaMutacao <= 0.05) {
//            int tamanhoTorneio = 2;
//            while (tamanhoTorneio <= 5) {
//                Evolucao evolucao = new Evolucao(taxaMutacao, tamanhoTorneio, true, caminho);
//                int tamanhoPop = 50;
//                while (tamanhoPop <= 200) {
//                    int geracoes = 10;
//                    while (geracoes <= 1000) {
//                        Populacao populacao = new Populacao(tamanhoPop, true, caminho);
//                        //System.out.println(populacao.getIndividuoApto());
//                        //System.out.println("Distancia inicial = " + populacao.getIndividuoApto().getDistancia());
//                        for (int i = 0; i < geracoes; i++) {
//                            populacao = evolucao.desenvolverPopulacao(populacao);
//                        }
//                        //System.out.println("tamanhoPop = " + tamanhoPop);
//                        //System.out.println("taxaMutacao = " + taxaMutacao);
//                        //System.out.println("tamanhoTorneio = " + tamanhoTorneio);
//                        //System.out.println("geracoes = " + geracoes);
//                        //System.out.println("Distancia final = " + populacao.getIndividuoApto().getDistancia());
//                        if (populacao.getIndividuoApto().getDistancia() < bestCost) {
//                            bestCost = populacao.getIndividuoApto().getDistancia();
//                        }
//                        //System.out.println("Solucao:");
//                        //System.out.println(populacao.getIndividuoApto());
//                        //System.out.println("Fim");
//                        //System.out.println("-------------------------------------------");
//                        geracoes *= 10;
//                    }
//                    tamanhoPop += 50;
//                }
//                tamanhoTorneio++;
//            }
//            taxaMutacao = taxaMutacao + 0.01;
//        }
//
//        System.out.println("best = " + bestCost);

    }
}
