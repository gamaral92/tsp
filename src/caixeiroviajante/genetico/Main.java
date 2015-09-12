/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixeiroviajante.genetico;

/**
 *
 * @author gabrielamaral
 */
public class Main {
    
    public static void main(String[] args) {
        Caminho caminho = new Caminho();
        caminho.lerArquivo("gr137.tsp");
        
        Populacao p = new Populacao(50, true, caminho);
        System.out.println("Distancia inicial = " + p.getApto().getDistancia());
        
        Evolucao evolucao = new Evolucao(0.0015, 5, true, caminho);
        
        p = evolucao.desenvolverPopulacao(p);
        for (int i = 0; i < 100; i++) {
            p = evolucao.desenvolverPopulacao(p);
        }
        
        System.out.println("Fim");
        System.out.println("Distancia final = " + p.getApto().getDistancia());
        System.out.println("Solucao:");
        System.out.println(p.getApto());
    }
    
}
