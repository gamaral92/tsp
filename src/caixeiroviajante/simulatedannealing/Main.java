package caixeiroviajante.simulatedannealing;

import caixeiroviajante.Caminho;

/**
 *
 * @author a11030
 */
public class Main {

    public static void main(String[] args) {
        Caminho caminho = new Caminho();
        //caminho.lerArquivo("burma14.tsp"); //3323
        //caminho.lerArquivo("ulysses16.tsp"); //6859
        //caminho.lerArquivo("ulysses22.tsp"); //7013
        //caminho.lerArquivo("gr96.tsp"); //55209
        caminho.lerArquivo("gr137.tsp"); //69853
        
        double temperatura = 100000;
        double taxaEsfriamento = 0.000001;

        SimulatedAnnealing sa = new SimulatedAnnealing(temperatura, taxaEsfriamento, caminho);
        System.out.println("Inicio:");
        System.out.println(sa.getMelhorIndividuo());
        System.out.println("Distancia inicial = " + sa.getMelhorIndividuo().getDistancia());
        sa.resfriar();
        System.out.println("Solucao:");
        System.out.println(sa.getMelhorIndividuo());
        System.out.println("Distancia final = " + sa.getMelhorIndividuo().getDistancia());
        System.out.println("gap = " + sa.getGap(69853.0));
    }

}
