package caixeiroviajante.hillclimbing;

/**
 *
 * @author gabrielamaral
 */
public class CaixeiroViajante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Problema problema = new Problema();
        problema.readFile("entrada.tsp");
        problema.hillClimbing();
    }
    
}
