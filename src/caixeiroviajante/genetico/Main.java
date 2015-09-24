package caixeiroviajante.genetico;

import java.util.Arrays;

/**
 *
 * @author gabrielamaral
 */
public class Main {

    public static void main(String[] args) {
        Caminho caminho = new Caminho();
        caminho.lerArquivo("burma14.tsp"); //3323
        //caminho.lerArquivo("ulysses16.tsp"); //6859
        //caminho.lerArquivo("ulysses22.tsp"); //7013
        //caminho.lerArquivo("gr96.tsp"); //55209
        //caminho.lerArquivo("gr137.tsp"); //69853

        Arquivo arquivo = new Arquivo("saida.txt");
        Arquivo arquivo1 = new Arquivo("saida2.txt");

        int cont = 0;

        while (cont < 5) {

            Evolucao e = new Evolucao(0.4, (int) (caminho.getNumeroDeCidades() * 0.15), true, caminho);
            //[tamanhoPop, taxaMutacao, tamanhoTorneio, geracoes]
            Populacao p = new Populacao(caminho.getNumeroDeCidades() * 10, true, caminho);
            System.out.println(p.getIndividuoMaisApto());
            System.out.println("Distancia inicial = " + p.getIndividuoMaisApto().getDistancia());
            for (int i = 0; i < 4000; i++) {
                p = e.desenvolverPopulacao(p);
                String melhor = p.getIndividuoMaisApto().getDistancia() + "\t";
                arquivo1.escrever(melhor);
            }
            arquivo1.quebraLinha();
            arquivo1.salvar();
            System.out.println("Solucao:");
            System.out.println(p.getIndividuoMaisApto());
            System.out.println("Distancia final = " + p.getIndividuoMaisApto().getDistancia());
            System.out.println("gap = " + p.getGap(3323.0));
            String gap = p.getGap(3323.0) + "";
            arquivo.escrever(gap);
            arquivo.quebraLinha();
            arquivo.salvar();
            cont++;
        }

        arquivo.fecharRecursos();

//        double bestCost = Integer.MAX_VALUE;
//
//        double[] parametros = new double[4];
//
//        double taxaMutacao = 0.01;
//        while (taxaMutacao <= 0.1) {
//            int tamanhoTorneio = 2;
//            while (tamanhoTorneio <= caminho.getNumeroDeCidades()) {
//                Evolucao evolucao = new Evolucao(taxaMutacao, tamanhoTorneio, true, caminho);
//                int tamanhoPop = caminho.getNumeroDeCidades();
//                while (tamanhoPop <= caminho.getNumeroDeCidades() * 5) {
//                    int geracoes = 100;
//                    while (geracoes <= 2000) {
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
//                        geracoes += 100;
//                    }
//                    tamanhoPop *= (int) ((caminho.getNumeroDeCidades() * 5) * 0.1);
//                }
//                tamanhoTorneio += (int) (caminho.getNumeroDeCidades() * 0.1);
//            }
//            taxaMutacao = taxaMutacao + 0.01;
//        }
//
//        System.out.println("best = " + bestCost);
//        System.out.println(Arrays.toString(parametros));
    }
}
