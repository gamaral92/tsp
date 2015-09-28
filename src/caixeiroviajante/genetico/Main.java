package caixeiroviajante.genetico;

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
        //caminho.lerArquivo("gr96.tsp"); //55209
        caminho.lerArquivo("gr137.tsp"); //69853

        Evolucao e = new Evolucao(0.085, 25, caminho);
        Populacao p = new Populacao(100, true, caminho);
        System.out.println(p.getIndividuoMaisApto());
        System.out.println("Distancia inicial = " + p.getIndividuoMaisApto().getDistancia());
        System.out.println("");
        for (int i = 0; i < 5000; i++) {
            p = e.desenvolverPopulacao(p);
        }
        System.out.println("Solucao:");
        System.out.println(p.getIndividuoMaisApto());
        System.out.println("Distancia final = " + p.getIndividuoMaisApto().getDistancia());
        System.out.println("gap = " + p.getGap(69853.0));
    }
}
