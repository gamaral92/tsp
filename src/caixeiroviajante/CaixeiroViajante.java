/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package caixeiroviajante;

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